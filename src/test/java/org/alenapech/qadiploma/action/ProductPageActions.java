package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public interface ProductPageActions {

    default void Add_Product_To_My_Bag(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("24")));
        page.waitForTimeout(3000);
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ДОБАВИТЬ В КОРЗИНУ")));
    }

}
