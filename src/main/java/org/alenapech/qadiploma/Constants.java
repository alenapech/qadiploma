package org.alenapech.qadiploma;

import org.alenapech.qadiploma.scenario.BrowserName;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Constants {

    interface Variables {
        String BROWSERS_VARIABLE           = "browsers";
        String BROWSERS_VARIABLE_DELIMITER = ",";
    }

    interface Scenarios {

    }

    interface Errors {
        String ILLEGAL_BROWSER_NAME_ARGUMENT = "Illegal Browser Name Argument. Check \"browsers\" variable, possible values are "
                + Arrays.stream(BrowserName.values()).map(v -> v.toString()).collect(Collectors.toSet());
    }

}
