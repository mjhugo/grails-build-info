package com.piragua.buildinfo


class ControllerReloadFunctionalTests extends functionaltestplugin.FunctionalTestCase {

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
