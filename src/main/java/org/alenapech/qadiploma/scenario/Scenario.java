package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import org.alenapech.qadiploma.Constants;

public interface Scenario extends Constants, Runnable {

    void start(Browser browser, BrowserContext context);

}
