package com.piragua.buildinfo

import grails.test.AbstractCliTestCase

import java.util.zip.ZipEntry
import java.util.zip.ZipFile

class CreateWarEventTests extends AbstractCliTestCase {

    void testCreateWar(){
        execute (['war', '-non-interactive'])

        assert waitForProcess() == 0

        verifyHeader()

        Properties props = new Properties()
        props.load(new ZipFile('target/bookstore-0.1.war').getInputStream(new ZipEntry('WEB-INF/classes/application.properties')))

        assert props['scm.version']
        assert props['build.date']

        assert props['who.was.here'] == 'hugo'

    }

}