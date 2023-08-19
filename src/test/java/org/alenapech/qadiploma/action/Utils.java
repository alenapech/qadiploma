package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assumptions;
import org.opentest4j.AssertionFailedError;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Utils {

    public static void assertThatVisibleAndScroll(Locator locator) {
        assertThat(locator).isVisible();
        locator.scrollIntoViewIfNeeded();
    }

    public static void assertThatVisibleAndClick(Locator locator) {
        assertThat(locator).isVisible();
        locator.click();
    }

    public static void assertThatVisibleAndFill(Locator locator, String value) {
        assertThat(locator).isVisible();
        locator.click();
        locator.fill(value);
        locator.press("Enter");
    }

    public static void assertThatVisibleAndHover(Locator locator) {
        assertThat(locator).isVisible();
        locator.hover();
    }

    public static void assumptionThatVisibleAndClickAndAssertThatNotVisible(Locator locator) {
        //popup may not exist
        //if the assumption is wrong, the test will be skipped
        //https://www.baeldung.com/junit-conditional-assume
        Assumptions.assumeTrue(() -> {
            try {
                assertThat(locator).isVisible();
                return true;
            } catch (AssertionFailedError e) {
                return false;
            }
        });
        locator.click();
        assertThat(locator).not().isVisible();
    }

}
