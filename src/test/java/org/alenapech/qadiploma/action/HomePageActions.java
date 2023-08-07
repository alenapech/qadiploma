package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assumptions;
import org.opentest4j.AssertionFailedError;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public interface HomePageActions {

    default void Open_Home_Page(Page page) {
        page.navigate("https://www.lcwaikiki.kz/ru-RU/KZ");
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ", page.url());
    }

    default void Close_Popup_if_Needed(Page page) {
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

    default void Show_Account_Actions_Dropdown_List(Page page) {
        Utils.assertThatVisibleAndHover(page.locator("a").filter(new Locator.FilterOptions().setHasText("Войти")).first());
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
    }

    default void Open_Account_Creation_Form(Page page) {
        Utils.assertThatVisibleAndHover(page.locator("a").filter(new Locator.FilterOptions().setHasText("Войти")).first());
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/register", page.url());
    }

    default void Open_Login_Form(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Войти")));
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/login", page.url());
    }

}
