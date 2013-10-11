package grails.plugin.buildinfo

import org.codehaus.groovy.grails.commons.ConfigurationHolder


class BuildInfoController {
 
    static final List buildInfoProperties = ['build.date', 'scm.version', 'environment.BUILD_NUMBER', 'environment.BUILD_ID', 'environment.BUILD_TAG', 'environment.GIT_BRANCH', 'environment.GIT_COMMIT'] 

    def index = { 
        def buildInfoConfig = ConfigurationHolder.config?.buildInfo
        def customProperties = buildInfoProperties
        if (buildInfoConfig?.properties?.exclude){
            customProperties -= buildInfoConfig.properties.exclude
        }
        if (buildInfoConfig?.properties?.add){
            customProperties += buildInfoConfig.properties.add
        }

        Map model = [buildInfoProperties: customProperties]
        render(view:'index', model:model)
    }
}
