@echo off

set JAVA_HOME="C:\Program Files\Java\graalvm-ce-java11-21.3.0\bin"
%JAVA_HOME%\java -cp "*;test-classes;lib\*" org.junit.platform.console.ConsoleLauncher --select-class org.alenapech.qadiploma.suite.WebkitSuite
pause