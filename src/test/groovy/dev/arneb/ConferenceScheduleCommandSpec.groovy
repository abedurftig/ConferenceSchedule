package dev.arneb

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ConferenceScheduleCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test ConferenceSchedule with command line option"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = ['-v'] as String[]
        PicocliRunner.run(ConferenceScheduleCommand, ctx, args)

        expect:
        baos.toString().contains('Hi!')
    }
}

