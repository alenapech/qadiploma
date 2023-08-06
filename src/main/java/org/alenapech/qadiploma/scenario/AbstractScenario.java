package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;

public abstract class AbstractScenario implements Scenario {

    protected Logger logger;
    protected BrowserName browserName;
    private BrowserType.LaunchOptions launchOptions;

    public AbstractScenario(BrowserName browserName, BrowserType.LaunchOptions launchOptions) {
        this.browserName = browserName;
        this.launchOptions = launchOptions;
    }

    private void initThreadContextVars() {
        // these thread context variables is being used in logging
        ThreadContext.put("browser", browserName.toString());
    }

    @Override
    public void run() {
        initThreadContextVars();
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = getBrowserType(playwright);
            Browser browser = browserType.launch(launchOptions);
            BrowserContext context = browser.newContext();
            start(browser, context);
        }
    }

    BrowserType getBrowserType(Playwright playwright) {
        switch (browserName) {
            case CHROMIUM:
                return playwright.chromium();
            case WEBKIT:
                return playwright.webkit();
            case FIREFOX:
                return playwright.firefox();
            default:
                logger.error(Errors.ILLEGAL_BROWSER_NAME_ARGUMENT);
                throw new IllegalArgumentException(Errors.ILLEGAL_BROWSER_NAME_ARGUMENT);
        }
    }

    public abstract void start(Browser browser, BrowserContext context);

    @Override
    public String toString() {
        return "AbstractScenario{" +
                "browserName=" + browserName +
                ", launchOptions=" + launchOptions +
                '}';
    }
}
