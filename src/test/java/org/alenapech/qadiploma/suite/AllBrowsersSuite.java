package org.alenapech.qadiploma.suite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("All Browsers Suite")
public class AllBrowsersSuite {

    @Nested
    class ChromiumTest extends ChromiumSuite {
    }

    @Nested
    class FirefoxTest extends FirefoxSuite {
    }

    @Nested
    public class WebkitTest extends WebkitSuite {
    }

}
