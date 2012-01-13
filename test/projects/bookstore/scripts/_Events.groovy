eventBuildInfoAddPropertiesStart = {warname, stagingDir ->
    Ant.propertyfile(file: "${stagingDir}/WEB-INF/classes/application.properties") {
        entry(key: 'who.was.here', value: 'hugo')
    }
}