import org.springframework.core.io.FileSystemResource
import org.codehaus.groovy.grails.commons.ControllerArtefactHandler
import org.codehaus.groovy.grails.commons.TagLibArtefactHandler
import org.codehaus.groovy.grails.commons.ServiceArtefactHandler

class BuildInfoGrailsPlugin {
    // the plugin version
    def version = "1.2.6"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Mike Hugo"
    def authorEmail = "mike@piragua.com"
    def title = "Build Info"
    def description = '''
Provides a controller/view that display basic information about the war file including the
* date/time the war file was built
* Source Control Revision Number (Git and Subversion)
* application version number
* grails version
* grails environment (currently running, not necessarily the environment used to build the war file)
* plugins installed (and which version)

If Hudson/Jenkins is used to build the war file the following Hudson environment variables are also displayed:
* BUILD_NUMBER
* BUILD_ID
* BUILD_TAG
* SVN_REVISION
* GIT_COMMIT
* GIT_BRANCH
'''

    def documentation = "http://grails.org/plugin/build-info"
    def license = "APACHE"
    def developers = [ [ name: "Ronny Løvtangen", email: "ronny@lovtangen.com" ]]
    def issueManagement = [ system: "Github", url: "https://github.com/mjhugo/grails-build-info/issues" ]
    def scm = [ url: "https://github.com/mjhugo/grails-build-info" ]

//
//    def watchedResources = ["file:${getPluginLocation()}/web-app/**",
//            "file:${getPluginLocation()}/grails-app/controllers/**/*Controller.groovy",
//            "file:${getPluginLocation()}/grails-app/services/**/*Service.groovy",
//            "file:${getPluginLocation()}/grails-app/taglib/**/*TagLib.groovy"
//    ]
//
//    def onChange = { event ->
//        println event
//        if (!isBasePlugin()) {
//            if (event.source instanceof FileSystemResource && event.source?.path?.contains('web-app')) {
//                def ant = new AntBuilder()
//                ant.copy(todir: "./web-app/plugins/build-info-${event.plugin.version}") {
//                    fileset(dir: "${getPluginLocation()}/web-app")
//                }
//            } else if (application.isArtefactOfType(ControllerArtefactHandler.TYPE, event.source)) {
//                manager?.getGrailsPlugin("controllers")?.notifyOfEvent(event)
//                // this injects the tag library namespaces back into the controller after it is reloaded
//                manager?.getGrailsPlugin("groovyPages")?.notifyOfEvent(event)
//            } else if (application.isArtefactOfType(TagLibArtefactHandler.TYPE, event.source)) {
//                manager?.getGrailsPlugin("groovyPages")?.notifyOfEvent(event)
//            } else if (application.isArtefactOfType(ServiceArtefactHandler.TYPE, event.source)) {
//                manager?.getGrailsPlugin("services")?.notifyOfEvent(event)
//            }
//        }
//        // watching is modified and reloaded. The event contains: event.source,
//        // event.application, event.manager, event.ctx, and event.plugin.
//    }
//
//    ConfigObject getBuildConfig() {
//        GroovyClassLoader classLoader = new GroovyClassLoader(getClass().getClassLoader())
//        ConfigObject buildConfig = new ConfigSlurper().parse(classLoader.loadClass('BuildConfig'))
//        return buildConfig
//    }
//
//    String getPluginLocation() {
//        return getBuildConfig()?.grails?.plugin?.location?.'build-info'
//    }
    

}
