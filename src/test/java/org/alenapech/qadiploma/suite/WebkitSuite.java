package org.alenapech.qadiploma.suite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages("org.alenapech.qadiploma.scenario.webkit")
@Suite
@SuiteDisplayName("Webkit Suite")
public class WebkitSuite {

}
