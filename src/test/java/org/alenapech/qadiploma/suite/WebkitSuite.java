package org.alenapech.qadiploma.suite;

import org.alenapech.qadiploma.scenario.AbstractCheckOrderTest;
import org.alenapech.qadiploma.scenario.AbstractCreateAccountTest;
import org.alenapech.qadiploma.scenario.AbstractLoginTest;
import org.alenapech.qadiploma.scenario.WebkitBrowserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("Webkit Suite")
public class WebkitSuite {
    @Nested
    class CheckOrderTest extends AbstractCheckOrderTest implements WebkitBrowserTest {}
    @Nested
    class CreateAccountTest extends AbstractCreateAccountTest implements WebkitBrowserTest {}
    @Nested
    class LoginTest extends AbstractLoginTest implements WebkitBrowserTest {}


}
