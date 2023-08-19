package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public interface MyBagPageActions {

    default void Check_Empty_Bag(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Ваша корзина пуста"));
    }

    default void Search_Product_From_My_Bag_Page(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Поиск"), "Женские носки");
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Pattern.compile("LC WAIKIKI"))).first());
    }

    default void Check_Not_Empty_Bag(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Моя корзина (1 Товар)"));
    }

    default void Delete_Product_From_Bag(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Удалить")));
        Utils.assertThatVisibleAndClick(page.getByText("Удалить", new Page.GetByTextOptions().setExact(true)));
        Utils.assertThatVisibleAndScroll(page.getByText("Ваша корзина пуста"));
    }

}
