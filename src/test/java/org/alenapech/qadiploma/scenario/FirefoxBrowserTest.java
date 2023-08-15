package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public interface FirefoxBrowserTest extends BrowserTest {

    default BrowserType getBrowserType(Playwright playwright) {
        return playwright.firefox();
    }

}
