package org.alenapech.qadiploma.scenario.webkit;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.alenapech.qadiploma.scenario.AbstractLoginTest;

public class LoginTest extends AbstractLoginTest {
    @Override
    protected BrowserType getBrowserType(Playwright playwright) {
        return playwright.webkit();
    }
}
