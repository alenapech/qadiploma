package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public interface LoginPageActions {

    default void Click_Login_Button(Page page) {
        page.waitForTimeout(1500);//TODO: we should wait for RECAPTCHA somehow (it's not stable now without timeout)
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Войти").setExact(true)));
    }

    default void Check_Validation_for_Empty_CAPTCHA(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, пройдите проверку безопасности"));
    }

    default void Check_Validation_for_Empty_Password(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш пароль."));
    }

    default void Check_Validation_for_Empty_Mail(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш адрес эл почты."));
    }

    default void Check_Validation_for_Incorrect_Mail(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш e-mail"), "1");
        assertThat(page.getByText("Пожалуйста, введите действительный адрес эл почты.")).isVisible();
    }
}
