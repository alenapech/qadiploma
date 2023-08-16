package org.alenapech.qadiploma.suite;

import org.alenapech.qadiploma.scenario.AbstractCheckOrderTest;
import org.alenapech.qadiploma.scenario.AbstractCreateAccountTest;
import org.alenapech.qadiploma.scenario.AbstractLoginTest;
import org.alenapech.qadiploma.scenario.ChromiumBrowserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("Chromium Suite")
public class ChromiumSuite {
    @Nested
    class CheckOrderTest extends AbstractCheckOrderTest implements ChromiumBrowserTest {}
    @Nested
    class CreateAccountTest extends AbstractCreateAccountTest implements ChromiumBrowserTest {}
    @Nested
    public class LoginTest extends AbstractLoginTest implements ChromiumBrowserTest {}

}
