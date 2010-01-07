eventCreateWarStart = {warname, stagingDir ->
    Ant.propertyfile(file: "${stagingDir}/WEB-INF/classes/application.properties") {
        if (Ant.antProject.properties."BUILD_NUMBER") {
            entry(key: 'build.number', value: Ant.antProject.properties."BUILD_NUMBER")
        }
        if (Ant.antProject.properties."BUILD_ID") {
            entry(key: 'build.id', value: Ant.antProject.properties."BUILD_ID")
        }
        if (Ant.antProject.properties."BUILD_TAG") {
            entry(key: 'build.tag', value: Ant.antProject.properties."BUILD_TAG")
        }
        entry(key: 'scm.version', value: getRevision())
        entry(key: 'build.date', value: new Date())
    }
}

def getRevision() {
    // client provided closure to determine revision
    def determineRevisionClosure = buildConfig.buildinfo.determineRevision
    if (determineRevisionClosure instanceof Closure) {
        return determineRevisionClosure()
    }

    // try to get revision from Hudson
    def scmVersion = Ant.antProject.properties."SVN_REVISION"

    // if Hudson env variable not found, try file system (for SVN)
    if (!scmVersion) {
        File entries = new File(basedir, '.svn/entries')
        if (entries.exists()) {
            scmVersion = entries.text.split('\n')[3].trim()
        }
    }

    return scmVersion ?: 'UNKNOWN'
}