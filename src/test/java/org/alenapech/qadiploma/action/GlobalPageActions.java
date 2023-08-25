package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface GlobalPageActions {

    default void Change_Local_To_Italy(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Italia | Italy")));
        assertEquals("https://www.lcwaikiki.it/en-US/IT", page.url());
    }

}
