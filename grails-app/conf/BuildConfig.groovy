grails.project.dependency.resolution = {
    inherits("global")

    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        //for the release plugin..
        build "org.apache.httpcomponents:httpclient:4.0.3"
        build "org.apache.ivy:ivy:2.2.0"
        build "org.grails.plugins:resources:1.2.RC2"

        // We need to replace the spock 0.6 version that comes with the GWT plugin. Otherwise the tests fail with a compilation error.
        // See documentation about Grails 2.2: http://grails.org/plugin/spock
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        build ":release:2.0.4"

        // We need to replace the spock 0.6 version that comes with the GWT plugin. Otherwise the tests fail with a compilation error.
        // See documentation about Grails 2.2: http://grails.org/plugin/spock
        test(":spock:0.7") {
            exclude "spock-grails-support"
            export = false
        }
    }
}

grails.release.scm.enabled = false

// Needed to run commands locally that trip over the GWT_HOME check.
gwt { version = "2.4.0" }
