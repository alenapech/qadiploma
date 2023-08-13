package org.alenapech.qadiploma.scenario.firefox;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.alenapech.qadiploma.scenario.AbstractCreateAccountTest;

public class CreateAccountTest extends AbstractCreateAccountTest {
    @Override
    protected BrowserType getBrowserType(Playwright playwright) {
        return playwright.firefox();
    }
}
