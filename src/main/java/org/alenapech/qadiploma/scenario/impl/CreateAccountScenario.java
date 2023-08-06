package org.alenapech.qadiploma.scenario.impl;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.alenapech.qadiploma.scenario.AbstractScenario;
import org.alenapech.qadiploma.scenario.BrowserName;
import org.alenapech.qadiploma.scenario.ScenarioUtils;
import org.opentest4j.AssertionFailedError;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAccountScenario extends AbstractScenario {

    public CreateAccountScenario(BrowserName browserName) {
        this(browserName, null);
    }

    public CreateAccountScenario(BrowserName browserName, BrowserType.LaunchOptions launchOptions) {
        super(browserName, launchOptions);
        logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void start(Browser browser, BrowserContext context) {
        logger.info("Scenario start");
        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        Page page = browser.newPage();


        page.navigate("https://www.lcwaikiki.kz/ru-RU/KZ");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "1.png")));

        Locator locator1 = page.locator("#ins-web-wheel-of-fortune-adaptive").getByText("×");
        ScenarioUtils.softAssertThatVisible(locator1);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "2.png")));
        locator1.click();

        page.locator("a").filter(new Locator.FilterOptions().setHasText("Войти")).first().hover();
        Locator locator2 = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет"));
        assertThat(locator2).isVisible();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "3.png")));
        locator2.click();

        Locator locator3 = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет"));
        assertThat(locator3).isVisible();
        locator3.scrollIntoViewIfNeeded();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "4.png")));
        locator3.click();



//        assertThat(page.locator("#google-reCaptcha div").nth(2)).isVisible();
//        page.frameLocator("iframe[name=\"a-f649oly64mtb\"]").getByText("Я не робот").click();
//        page.frameLocator("iframe[name=\"a-f649oly64mtb\"]").getByRole(AriaRole.CHECKBOX, new FrameLocator.GetByRoleOptions().setName("Я не робот")).click();
//        assertThat(page.frameLocator("iframe[name=\"a-f649oly64mtb\"]").getByText("Я не робот")).isVisible();
//        page.frameLocator("iframe[name=\"a-f649oly64mtb\"]").getByText("Я не робот");

//        assertThat(page.getByText("Пожалуйста, пройдите проверку безопасности")).isVisible();
//        page.getByText("Пожалуйста, пройдите проверку безопасности").scrollIntoViewIfNeeded();
//        page.getByText("Пожалуйста, пройдите проверку безопасности").highlight();
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "5.png")));
//
//        assertThat(page.getByText("Пожалуйста, введите действительный номер телефона Пример: 007 XXX XXX XX XX")).isVisible();
//        page.getByText("Пожалуйста, введите действительный номер телефона Пример: 007 XXX XXX XX XX").scrollIntoViewIfNeeded();
//        page.getByText("Пожалуйста, введите действительный номер телефона Пример: 007 XXX XXX XX XX").highlight();
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "6.png")));
//
//        assertThat(page.getByText("Пожалуйста, введите Ваш пароль.")).isVisible();
//        page.getByText("Пожалуйста, введите Ваш пароль.").scrollIntoViewIfNeeded();
//        page.getByText("Пожалуйста, введите Ваш пароль.").highlight();
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "7.png")));
//
//        assertThat(page.getByText("Пожалуйста, введите Ваш адрес эл почты.")).isVisible();
//        page.getByText("Пожалуйста, введите Ваш адрес эл почты.").scrollIntoViewIfNeeded();
//        page.getByText("Пожалуйста, введите Ваш адрес эл почты.").highlight();
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + "8.png")));


//        page.navigate("https://www.lcwaikiki.kz/ru-RU/KZ");
//        page.navigate("https://www.lcwaikiki.kz/ru-RU/KZ/register");
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")).click();
//        page.getByText("Пожалуйста, введите Ваш пароль.").click();
//        page.getByText("Пожалуйста, введите действительный номер телефона Пример: 007 XXX XXX XX XX").click();
//        page.getByText("Пожалуйста, пройдите проверку безопасности").click();
//        page.getByPlaceholder("Ваш e-mail").click();
//        page.getByPlaceholder("Ваш e-mail").fill("1");
//        page.getByText("Пожалуйста, введите действительный адрес эл почты.").click();
//        page.getByText("Пожалуйста, введите действительный адрес эл почты.").click();
//        page.getByPlaceholder("Ваш пароль").click();
//        page.getByPlaceholder("Ваш пароль").fill("1");
//        page.getByText("Пароль должен быть от 6 до 20 символов и содержать цифры и латинские буквы.").first().click();
//        page.frameLocator("iframe[name=\"a-cj3jm31ryf70\"]").getByRole(AriaRole.CHECKBOX, new FrameLocator.GetByRoleOptions().setName("Я не робот")).click();
//        getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Я не робот"))
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")).click();
//        page.getByText("").click();
//        page.getByPlaceholder("Ваш пароль").click();
//        page.getByPlaceholder("Ваш пароль").fill("");
//        page.getByText("Пожалуйста, введите Ваш пароль.").click();

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        logger.info("Scenario end");
    }
}
