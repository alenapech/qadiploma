package org.alenapech.qadiploma.suite;

import org.alenapech.qadiploma.scenario.AbstractCheckOrderTest;
import org.alenapech.qadiploma.scenario.AbstractCreateAccountTest;
import org.alenapech.qadiploma.scenario.AbstractLoginTest;
import org.alenapech.qadiploma.scenario.FirefoxBrowserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("Firefox Suite")
public class FirefoxSuite {
    @Nested
    class CheckOrderTest extends AbstractCheckOrderTest implements FirefoxBrowserTest {}
    @Nested
    class CreateAccountTest extends AbstractCreateAccountTest implements FirefoxBrowserTest {}
    @Nested
    class LoginTest extends AbstractLoginTest implements FirefoxBrowserTest {}

}
