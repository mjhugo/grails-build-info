package com.piragua.buildinfo

import grails.util.Environment
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class ControllerReloadFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    def grailsApplication

    void testBuildInfoPage() {
        get('/buildInfo')
        assertStatus 200

//        new File("${System.getProperty('base.dir')}/../../../grails-app/controllers/com/piragua/buildinfo/BuildInfoController.groovy").lastModified = new Date().time
//        //println controller.text
//        // allow grails to reload the controller
//        Thread.sleep(3000)
//
//        get('/buildInfo')
//        assertStatus 200

    }
}
