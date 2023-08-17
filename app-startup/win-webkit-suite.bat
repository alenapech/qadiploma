@echo off

set JAVA_HOME="C:\Program Files\Java\graalvm-ce-java11-21.3.0"
%JAVA_HOME%\bin\java -cp "*;test-classes;lib\*" org.junit.platform.console.ConsoleLauncher --select-class org.alenapech.qadiploma.suite.WebkitSuite
pause