package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.scenario.impl.CreateAccountScenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ScenarioFactory {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Scenario> getScenarios(Set<BrowserName> browserNames) {
        logger.info("Getting scenarios for {}", browserNames);
        List<Scenario> scenarios = new ArrayList<>();

        for (BrowserName browserName : browserNames) {
            /* Scenarios initialization start */
            scenarios.add(new CreateAccountScenario(browserName));
            /* Scenarios initialization end */
        }

        logger.info("Scenarios for {}: {}", browserNames, scenarios);
        return scenarios;
    }
}
