package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public interface SearchOrderPageActions {

    default void Click_Search_Button(Page page) {
        page.waitForLoadState();
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Запросить")));
    }

    default void Check_Validation_for_Empty_Mail(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите Ваш адрес эл почты."));
    }

    default void Check_Validation_for_Empty_Order(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Пожалуйста, введите номер Вашего заказа."));
    }

    default void Check_Validation_for_Incorrect_Mail(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш e-mail"), "1");
        assertThat(page.getByText("Пожалуйста, введите действительный адрес эл почты.")).isVisible();
    }

    default void Check_Validation_for_Incorrect_Order(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Номер Вашего заказа"), "1");
        assertThat(page.getByText("Вы не полностью ввели номер заказа. Пожалуйста, проверьте!")).isVisible();
    }

    default void Open_Order_Details_Page(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Ваш e-mail"), "alenaryzhova@inbox.ru");
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Номер Вашего заказа"), "2307161700822");
        Click_Search_Button(page);
//        page.waitForLoadState();
//        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/order-detail/2307161700822", page.url());
        Utils.assertThatVisibleAndScroll(page.getByText("Заказ номер 2307161700822"));
    }
}
