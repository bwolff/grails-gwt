grails.project.dependency.resolution = {
    inherits("global")

    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        // We need to replace the spock 0.6 version that comes with the GWT plugin. Otherwise the tests fail with a compilation error.
        // See documentation about Grails 2.2: http://grails.org/plugin/spock
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        compile ":resources:1.2.RC2"

        build(":release:2.2.1") {
            export = false
        }

        // We need to replace the spock 0.6 version that comes with the GWT plugin. Otherwise the tests fail with a compilation error.
        // See documentation about Grails 2.2: http://grails.org/plugin/spock
        test(":spock:0.7") {
            exclude "spock-grails-support"
            export = false
        }
    }
}

// Needed to run commands locally that trip over the GWT_HOME check.
gwt { version = "2.4.0" }
