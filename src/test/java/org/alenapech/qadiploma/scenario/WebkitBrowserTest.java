package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public interface WebkitBrowserTest extends BrowserTest {

    default BrowserType getBrowserType(Playwright playwright) {
        return playwright.webkit();
    }

}
