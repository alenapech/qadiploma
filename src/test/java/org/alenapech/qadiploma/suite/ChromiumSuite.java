package org.alenapech.qadiploma.suite;

import org.alenapech.qadiploma.scenario.AbstractCheckOrderTest;
import org.alenapech.qadiploma.scenario.ChromiumBrowserTest;
import org.junit.jupiter.api.Nested;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Chromium Suite")
public class ChromiumSuite {
    @Nested
    class CheckOrderTest extends AbstractCheckOrderTest implements ChromiumBrowserTest {}
    @Nested
    class CreateAccountTest extends AbstractCheckOrderTest implements ChromiumBrowserTest {}
    @Nested
    public class LoginTest extends AbstractCheckOrderTest implements ChromiumBrowserTest {}

}
