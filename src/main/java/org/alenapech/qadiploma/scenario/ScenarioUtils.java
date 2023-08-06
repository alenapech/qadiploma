package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ScenarioUtils {

    private static Logger logger = LoggerFactory.getLogger(ScenarioUtils.class);

    public static void softAssertThatVisible(Locator locator) {
        softAssertThatVisible(locator, null);
    }

    public static void softAssertThatVisible(Locator locator, LocatorAssertions.IsVisibleOptions isVisibleOptions) {
        try {
            assertThat(locator).isVisible(isVisibleOptions);
        } catch (AssertionFailedError e) {
            logger.error(e.toString());
        }
    }

}
