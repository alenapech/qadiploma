package org.alenapech.qadiploma.suite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages("org.alenapech.qadiploma.scenario.firefox")
@Suite
@SuiteDisplayName("Firefox Suite")
public class FirefoxSuite {

}
