package org.alenapech.qadiploma;

import com.microsoft.playwright.*;
import org.alenapech.qadiploma.scenario.BrowserName;
import org.alenapech.qadiploma.scenario.Scenario;
import org.alenapech.qadiploma.scenario.ScenarioFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main implements Constants {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ScenarioFactory scenarioFactory = new ScenarioFactory();
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (Scenario scenario : scenarioFactory.getScenarios(getBrowserNames(), getLaunchOptions())) {
            executorService.submit(scenario);
        }
        ConcurrencyUtils.shutdownAndAwaitTermination(executorService); //TODO TBD we need to wait for the end of each thread
    }

    private static BrowserType.LaunchOptions getLaunchOptions() {
        return null; //TODO uncomment in PROD
//        return new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100); //TODO remove in PROD
    }

    private static Set<BrowserName> getBrowserNames() {
        String browsersValue = System.getProperty(Variables.BROWSERS_VARIABLE); // get "browsers" variable from app startup
        if (StringUtils.isEmpty(browsersValue))
//            return Set.of(BrowserName.values()); //TODO uncomment in PROD
            return Set.of(BrowserName.CHROMIUM); //TODO remove in PROD
        Set browserNames = Arrays.stream(browsersValue.split(Variables.BROWSERS_VARIABLE_DELIMITER))
                .map(String::trim)
                .map(BrowserName::fromValue)
                .collect(Collectors.toSet());
        logger.debug("\"browsers\" variable: {}", browserNames);
        return browserNames;
    }
}