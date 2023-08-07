package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public interface CreateAccountPageActions {

    default void Click_Account_Creation_Button(Page page) {
//        page.waitForTimeout(1500);
//        page.locator("#google-reCaptcha div").nth(2)
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
    }

    default void Check_Validation_for_Empty_CAPTCHA(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, пройдите проверку безопасности"));
    }

    default void Check_Validation_for_Empty_Phone(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите действительный номер телефона Пример: 007 XXX XXX XX XX"));
    }

    default void Check_Validation_for_Empty_Password(Page page) {
        page.getByPlaceholder("Ваш пароль").click(); //it will center the window on the "Password" field
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш пароль."));
    }

    default void Check_Validation_for_Empty_Mail(Page page) {
        page.getByPlaceholder("Ваш e-mail").click(); //it will center the window on the "Mail" field
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш адрес эл почты."));
    }

    default void Check_Validation_for_Incorrect_Password(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш пароль"), "1");
        assertThat(page.getByText("Пароль должен быть от 6 до 20 символов и содержать цифры и латинские буквы.").first()).isVisible();
    }

    default void Check_Validation_for_Incorrect_Mail(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш e-mail"), "1");
        assertThat(page.getByText("Пожалуйста, введите действительный адрес эл почты.")).isVisible();
    }

}
