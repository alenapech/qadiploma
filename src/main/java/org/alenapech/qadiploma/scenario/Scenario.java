package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.Browser;

public interface Scenario extends Constants, Runnable {

    void start(Browser browser);

}
