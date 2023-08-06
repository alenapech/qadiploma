package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.Constants;

public enum BrowserName {

    CHROMIUM("chromium"),
    WEBKIT("webkit"),
    FIREFOX("firefox");

    private String value;

    BrowserName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static BrowserName fromValue(String value) {
        for (BrowserName browserName : BrowserName.values()) {
            if (String.valueOf(browserName.value).equals(value)) {
                return browserName;
            }
        }
        throw new IllegalArgumentException(Constants.Errors.ILLEGAL_BROWSER_NAME_ARGUMENT);
    }
}
