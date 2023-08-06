package org.alenapech.qadiploma.scenario;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//https://stackoverflow.com/questions/54947645/junits-testmethodorder-annotation-not-working
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Create Account Scenario")
public class CreateAccountTest extends AbstractTest {
    @Test
    @Order(1)
    @DisplayName("Open the Page Step")
    void shouldOpenPage() {
        page.navigate("https://www.lcwaikiki.kz/ru-RU/KZ");
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ", page.url());
    }

    @Test
    @Order(2)
    @DisplayName("Close Popup if Needed")
    void shouldClosePopupIfExists() {
        Locator locator = page.locator("#ins-web-wheel-of-fortune-adaptive")
                .getByText("×");
        //popup may not exist
        //if the assumption is wrong, the test will be skipped
        //https://www.baeldung.com/junit-conditional-assume
        Assumptions.assumeTrue(() -> {
            try {
                assertThat(locator).isVisible();
                return true;
            } catch (AssertionFailedError e) {
                return false;
            }
        });
        locator.click();
        assertThat(locator).not().isVisible();
    }

    @Test
    @Order(3)
    @DisplayName("Show Dropdown List with Button to Open Account Creation Form")
    void shouldShowDropDownListForAccountCreation() {
        page.locator("a")
                .filter(new Locator.FilterOptions().setHasText("Войти"))
                .first()
                .hover();
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
    }

    @Test
    @Order(4)
    @DisplayName("Show Account Creation Form")
    void shouldShowFormForAccountCreation() {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/register", page.url());
    }

    @Test
    @Order(5)
    @DisplayName("Click Account Creation Button")
    void shouldClickOnAccountCreationButton() {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
    }

    @Test
    @Order(6)
    @DisplayName("Check Validation for Empty CAPTCHA")
    void shouldShowValidationMessageForEmptyCaptcha() {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, пройдите проверку безопасности"));
    }

    @Test
    @Order(7)
    @DisplayName("Check Validation for Empty Phone")
    void shouldShowValidationMessageForEmptyPhone() {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите действительный номер телефона Пример: 007 XXX XXX XX XX"));
    }

    @Test
    @Order(8)
    @DisplayName("Check Validation for Empty Password")
    void shouldShowValidationMessageForEmptyPassword() {
        page.getByPlaceholder("Ваш пароль").click(); //it will center the window on the "Password" field
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш пароль."));
    }

    @Test
    @Order(9)
    @DisplayName("Check Validation for Empty Mail")
    void shouldShowValidationMessageForEmptyMail() {
        page.getByPlaceholder("Ваш e-mail").click(); //it will center the window on the "Mail" field
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш адрес эл почты."));
    }

    @Test
    @Order(10)
    @DisplayName("Check Validation for Incorrect Password")
    void shouldShowValidationMessageForIncorrectPassword() {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш пароль"), "1");
        assertThat(page.getByText("Пароль должен быть от 6 до 20 символов и содержать цифры и латинские буквы.").first()).isVisible();
    }

    @Test
    @Order(11)
    @DisplayName("Check Validation for Incorrect Mail")
    void shouldShowValidationMessageForIncorrectMail() {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш e-mail"), "1");
        assertThat(page.getByText("Пожалуйста, введите действительный адрес эл почты.")).isVisible();
    }
}
