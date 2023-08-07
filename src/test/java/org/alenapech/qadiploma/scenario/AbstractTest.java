package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

//https://playwright.dev/java/docs/test-runners
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//https://junit.org/junit5/docs/snapshot/user-guide/#writing-tests-display-name-generator
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//https://stackoverflow.com/questions/54947645/junits-testmethodorder-annotation-not-working
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractTest {
    // Shared between all tests in the class.
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = context.newPage();
        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    @AfterAll
    void closeBrowser() {
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("reports/" + getReportName() + ".zip")));
        context.close();
        playwright.close();
    }

    abstract String getReportName();

}
