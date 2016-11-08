package grails.plugin.buildinfo

import grails.util.Holders
import grails.converters.JSON
import grails.converters.XML
import grails.util.Environment


class BuildInfoController {
    def grailsApplication
    def pluginManager

    static final List buildInfoProperties = ['build.date', 'scm.version', 'environment.BUILD_NUMBER', 'environment.BUILD_ID', 'environment.BUILD_TAG', 'environment.GIT_BRANCH', 'environment.GIT_COMMIT']

    def index = {
        def buildInfoConfig = Holders.config?.buildInfo
        def customProperties = buildInfoProperties
        if (buildInfoConfig?.properties?.exclude){
            customProperties -= buildInfoConfig.properties.exclude
        }
        if (buildInfoConfig?.properties?.add){
            customProperties += buildInfoConfig.properties.add
        }

        def buildInfo = [:]
        customProperties.findAll { grailsApplication?.metadata[it] }.each {
            buildInfo."${it}" = grailsApplication?.metadata[it]
        }

        def installedPlugins = [:]
        pluginManager?.allPlugins?.sort({it.name.toUpperCase()}).each {
            installedPlugins."${it.name}" = it.version
        }

        def runtimeEnvironment = [
            environment: Environment.current.name,
            'app.version': grailsApplication?.metadata['app.version'],
            'app.grails.version': grailsApplication?.metadata['app.grails.version'],
            'java.version': System.getProperty('java.version'),
            'host': getHostName()
        ]

        Map model = [
                buildInfoProperties: buildInfo,
                installedPlugins: installedPlugins,
                runtimeEnvironment: runtimeEnvironment
        ]

        withFormat {
            html { render(view: 'index', model: model) }
            json { render model as JSON }
            xml { render model as XML }
        }
    }
    
    private String getHostName() {
        String name;
        try {
            final InetAddress addr = InetAddress.getLocalHost();
            name = addr.getHostName();
        } catch (UnknownHostException ignore) {
            name = null;
        }
        return name;
    }
}
