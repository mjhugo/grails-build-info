class BuildInfoGrailsPlugin {
    // the plugin version
    def version = "1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.1.1 > *" //tested with 1.1.1 and higher, may or may not work for older versions of Grails
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Mike Hugo"
    def authorEmail = "mike@piragua.com"
    def title = "Build Info"
    def description = '''
Provides a controller/view that display basic information about the war file including the
* date/time the war file was built
* application version number
* grails version
* grails environment (currently running, not necessarily the environment used to build the war file)
* plugins installed (and which version)

If Hudson is used to build the war file the following Hudson environment variables are also displayed:
* BUILD_NUMBER
* BUILD_ID
* BUILD_TAG
* SVN_REVISION
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/build-info"

}
