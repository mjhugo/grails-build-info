eventCreateWarStart = {warname, stagingDir ->

    event("BuildInfoAddPropertiesStart", [warname, stagingDir])

    Ant.propertyfile(file: "${stagingDir}/WEB-INF/classes/application.properties") {
		Ant.antProject.properties.findAll({k,v-> k.startsWith('environment')}).each { k,v->
            entry(key: k, value: v)
		}
        entry(key: 'scm.version', value: getRevision())
        entry(key: 'build.date', value: new Date())
    }

    event("BuildInfoAddPropertiesEnd", [warname, stagingDir])

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

    // if Hudson/Jenkins env variable not found, try file system (for SVN)
    if (!scmVersion) {
        File entries = new File(basedir, '.svn/entries')
  		if (entries.exists() && entries.text.split('\n').length>3) {
	            scmVersion = entries.text.split('\n')[3].trim()
        }
    }

    return scmVersion ?: 'UNKNOWN'
}