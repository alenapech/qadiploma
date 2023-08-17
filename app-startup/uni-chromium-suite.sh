#!/usr/bin/sh

JAVA_HOME="/usr/lib/jvm/graalvm-ce-java11-21.3.0"
$JAVA_HOME/bin/java -cp "*:test-classes:lib/*" org.junit.platform.console.ConsoleLauncher --select-class org.alenapech.qadiploma.suite.ChromiumSuite