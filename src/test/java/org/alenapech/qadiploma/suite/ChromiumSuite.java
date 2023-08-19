package org.alenapech.qadiploma.suite;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@DisplayName("Chromium Suite")
@Suite
@SelectPackages("org.alenapech.qadiploma.scenario.chromium")
public class ChromiumSuite {
}
