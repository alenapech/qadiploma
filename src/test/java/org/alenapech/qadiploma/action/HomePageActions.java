package org.alenapech.qadiploma.action;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface HomePageActions {

    default void Open_Home_Page(Page page) {
        try {
            page.navigate("https://www.lcwaikiki.kz/ru-RU/KZ");
        } catch (TimeoutError e) {
            // just WA to avoid random TimeoutError, like https://github.com/microsoft/playwright/issues/12182
//            logger.warn("TimeoutError: {}", e);
        }
        Utils.assertThatVisibleAndScroll(page.locator("a").filter(new Locator.FilterOptions().setHasText("Войти")).first());
    }

    default void Close_Fortune_Popup_if_Needed(Page page) {
        Utils.assumptionThatVisibleAndClickAndAssertThatNotVisible(page.locator("#ins-web-wheel-of-fortune-adaptive")
                .getByText("×"));
    }

    default void Close_Notification_Popup_if_Needed(Page page) {
        Utils.assumptionThatVisibleAndClickAndAssertThatNotVisible(page.locator("#button-1580496494"));
    }

    default void Show_Account_Actions_Dropdown_List(Page page) {
        Utils.assertThatVisibleAndHover(page.locator("a").filter(new Locator.FilterOptions().setHasText("Войти")).first());
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
    }

    default void Open_Account_Creation_Page(Page page) {
        Utils.assertThatVisibleAndHover(page.locator("a").filter(new Locator.FilterOptions().setHasText("Войти")).first());
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Создать личный кабинет")));
        page.waitForLoadState();
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/register", page.url());
    }

    default void Open_Login_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Войти")));
        page.waitForLoadState();
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/login", page.url());
    }

    default void Open_Search_Order_From_Header_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.locator("#header__container").getByRole(AriaRole.LINK
                , new Locator.GetByRoleOptions().setName("Статус заказа")));
        page.waitForLoadState();
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/search-order", page.url());
    }

    default void Open_Search_Order_From_Footer_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.locator("#footer__container").getByRole(AriaRole.LINK
                , new Locator.GetByRoleOptions().setName("Статус заказа")));
        page.waitForLoadState();
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/search-order", page.url());
    }

    default void Search_Product(Page page) {
        Utils.assertThatVisibleAndFill(page.getByPlaceholder("Поиск"), "Женские носки");
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Pattern.compile("LC WAIKIKI"))).first());
    }

//    default void Open_Product_Quick_Details(Page page) {
//        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Pattern.compile("LC WAIKIKI"))).first());
//        Utils.assertThatVisibleAndScroll(page.getByText("Быстрый просмотр"));
//    }
//
//    default void Open_Product_Page_From_Quick_Details(Page page) {
//        Utils.assertThatVisibleAndClick(page.locator(".desktop-quick-look__image-box"));
//        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ДОБАВИТЬ В КОРЗИНУ")));
//    }

    default void Open_Product_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Pattern.compile("LC WAIKIKI"))).first());
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ДОБАВИТЬ В КОРЗИНУ")));
    }

    default void Open_Products_From_Catalog(Page page) {
        Utils.assertThatVisibleAndHover(page.locator("#header__container").getByRole(AriaRole.LINK
                , new Locator.GetByRoleOptions().setName("Для женщин").setExact(true)));
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Толстовки")));
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Pattern.compile("LC WAIKIKI"))).first());
    }

    default void Open_My_Favorite_List_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("Мой Список желаний")));
        page.waitForLoadState();
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/myfavoritelist", page.url());
    }

    default void Add_Product_To_Favorite_list(Page page) {
        Utils.assertThatVisibleAndClick(page.locator(".like-indicator").first());
        Utils.assertThatVisibleAndScroll(page.locator("#icon-liked path"));
    }

    default void Open_My_Bag_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("Моя корзина")));
        page.waitForLoadState();
        assertEquals("https://www.lcwaikiki.kz/ru-RU/KZ/mybag", page.url());
    }

    default void Check_Promo_Existence(Page page) {
        Utils.assertThatVisibleAndScroll(page.locator("div:nth-child(2) > .full-width-slider__link").first());
    }

    default void Open_Contact_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Свяжитесь с нами")));
        Utils.assertThatVisibleAndScroll(page.getByText("Юридический адрес компании LC Waikiki:"));
    }

    default void Open_Google_Play_Store_Page(Page page) {
        Page page1 = Utils.assertThatVisibleAndClickOpenningNewPage(page.locator(".col-lg-6 > div > a:nth-child(3)").first(), page);
        assertEquals("https://play.google.com/store/apps/details?id=com.lcwaikiki.global", page1.url());
        Utils.assertThatVisibleAndScroll(page1.getByText(Pattern.compile("LC Waikiki")).first());
    }

    default void Open_App_Store_Page(Page page) {
        Page page1 = Utils.assertThatVisibleAndClickOpenningNewPage(page.locator(".col-lg-6 > div > a").first(), page);
        assertEquals("https://apps.apple.com/us/app/lc-waikiki-kz/id1615048110", page1.url());
        Utils.assertThatVisibleAndScroll(page1.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(Pattern.compile("LC Waikiki"))));
    }

    default void Open_Global_Page(Page page) {
        Utils.assertThatVisibleAndClick(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Казахстан")));
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Italia | Italy")));
    }

    default void Accept_Italy_Location(Page page) {
        Utils.assertThatVisibleAndClick(page.getByText("Continue with lcwaikiki.it/en-US/IT"));
        Utils.assertThatVisibleAndScroll(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Outlet").setExact(true)));
    }

}
