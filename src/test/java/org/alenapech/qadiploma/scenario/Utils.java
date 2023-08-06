package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.Locator;

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

}
