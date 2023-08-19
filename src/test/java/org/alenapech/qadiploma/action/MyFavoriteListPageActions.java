package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public interface MyFavoriteListPageActions {

    default void Check_Empty_Favorite_List(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByText("Ваш Список желаний пока пуст"));
    }

    default void Search_Product_From_My_Favorite_Page(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Поиск"), "Женские носки");
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Pattern.compile("LC WAIKIKI"))).first());
    }

    default void Check_Not_Empty_Favorite_List(Page page) {
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Мой Список желаний")));
    }

    default void Remove_Product_From_Favorite_List(Page page) {
        Utils.assertThatVisibleAndClick(page.locator(".emi-icons-wrapper"));
        Check_Empty_Favorite_List(page);
    }

}
