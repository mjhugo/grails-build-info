eventCreateWarStart = {warname, stagingDir ->

    event("BuildInfoAddPropertiesStart", [warname, stagingDir])

    def properties = [:]
    Ant.antProject.properties.findAll({k,v-> k.startsWith('environment')}).each { k,v->
        properties[k] = v
    }
    properties['scm.version'] = getRevision()
    properties['build.date'] = new Date()

    writeProperties(properties, "${stagingDir}/WEB-INF/classes/application.properties")

    event("BuildInfoAddPropertiesEnd", [warname, stagingDir])

}

private void writeProperties(Map properties, String propertyFile) {
    Ant.propertyfile(file: propertyFile) {
        properties.each { k,v->
            entry(key: k, value: v)
        }
    }
}

def getRevision() {
    // client provided closure to determine revision
    def determineRevisionClosure = buildConfig.buildinfo.determineRevision
    if (determineRevisionClosure instanceof Closure) {
        return determineRevisionClosure()
    }

    // try to get revision from Hudson
    def scmVersion = Ant.antProject.properties."environment.SVN_REVISION"

    if (!scmVersion) {
		scmVersion = Ant.antProject.properties."environment.GIT_COMMIT"
	}

    // maybe a local git?
    if (!scmVersion) {
        try {
            def command = """git rev-parse HEAD"""
            def proc = command.execute()
            proc.waitFor()
            if (proc.exitValue() == 0) {
                scmVersion = proc.in.text
            }
        } catch (IOException e) {
            // oh well
        }
    }

    if (!scmVersion) {
        scmVersion = getRevisionFromSvnCli()
    }

    // if Hudson/Jenkins env variable not found, try file system (for SVN)
    if (!scmVersion) {
        File entries = new File(basedir, '.svn/entries')
  		if (entries.exists() && entries.text.split('\n').length>3) {
	            scmVersion = entries.text.split('\n')[3].trim()
        }
    }

    return scmVersion ?: 'UNKNOWN'
}

private String getRevisionFromSvnCli() {
    try {
        def command = 'svn info --xml'
        def proc = command.execute()
        def out = new ByteArrayOutputStream()
        proc.consumeProcessOutput(out, null) //prevent blocking in Windows due to a full output buffer
        int exitVal = proc.waitFor()
        if (exitVal == 0) {
            def slurper = new XmlSlurper().parseText(out.toString())
            return slurper.entry.@revision
        }
    } catch (ignore) {
        return null
    }
}