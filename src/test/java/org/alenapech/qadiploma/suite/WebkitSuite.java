package org.alenapech.qadiploma.suite;

import org.alenapech.qadiploma.scenario.AbstractCheckOrderTest;
import org.alenapech.qadiploma.scenario.WebkitBrowserTest;
import org.junit.jupiter.api.Nested;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Webkit Suite")
public class WebkitSuite {
    @Nested
    class CheckOrderTest extends AbstractCheckOrderTest implements WebkitBrowserTest {
    }
    @Nested
    class CreateAccountTest extends AbstractCheckOrderTest implements WebkitBrowserTest {
    }
    @Nested
    class LoginTest extends AbstractCheckOrderTest implements WebkitBrowserTest {
    }


}
