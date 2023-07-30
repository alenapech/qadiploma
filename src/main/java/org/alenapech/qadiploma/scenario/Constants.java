package org.alenapech.qadiploma.scenario;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Constants {

    interface Errors {
        String ILLEGAL_BROWSER_NAME_ARGUMENT = "Illegal Browser Name Argument. Check \"browsers\" variable, possible values are "
                + Arrays.stream(BrowserName.values()).map(v -> v.toString()).collect(Collectors.toSet());
    }
}
