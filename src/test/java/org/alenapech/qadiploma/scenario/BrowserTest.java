package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public interface BrowserTest {

    BrowserType getBrowserType(Playwright playwright);

}
