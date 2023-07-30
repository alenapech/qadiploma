package org.alenapech.qadiploma.scenario.impl;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import org.alenapech.qadiploma.scenario.AbstractScenario;
import org.alenapech.qadiploma.scenario.BrowserName;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class CreateAccountScenario extends AbstractScenario {

    public CreateAccountScenario(BrowserName browserName) {
        this(browserName, null);
    }

    public CreateAccountScenario(BrowserName browserName, BrowserType.LaunchOptions launchOptions) {
        super(browserName, launchOptions);
        logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void start(Browser browser) {
        logger.info("Scenario start");
        Page page = browser.newPage();
        page.navigate("https://playwright.dev/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + ".png")));
        logger.info("Scenario end");
    }
}
