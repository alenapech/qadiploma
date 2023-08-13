package org.alenapech.qadiploma.scenario.chromium;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.alenapech.qadiploma.scenario.AbstractCheckOrderTest;

public class CheckOrderTest extends AbstractCheckOrderTest {

    @Override
    protected BrowserType getBrowserType(Playwright playwright) {
        return playwright.chromium();
    }
}