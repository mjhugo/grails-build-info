package com.piragua.buildinfo

import grails.test.AbstractCliTestCase
import java.util.zip.ZipFile

class CreateWarEventTests extends AbstractCliTestCase {

    void testCreateWar(){
        execute (['war', '-non-interactive'])

        assertEquals 0, waitForProcess()

        verifyHeader()
        
        Properties props = new Properties()
        props.load(new ZipFile('target/bookstore-0.1.war').getInputStream('WEB-INF/classes/application.properties'))

        assertNotNull props['scm.version']
        assertNotNull props['build.date']

        assertEquals 'hugo', props['who.was.here']

    }

}