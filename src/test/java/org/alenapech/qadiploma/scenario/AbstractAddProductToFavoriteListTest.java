package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.alenapech.qadiploma.action.MyFavoriteListPageActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Add Product To Favorite List Test")
public abstract class AbstractAddProductToFavoriteListTest extends AbstractTest implements HomePageActions, MyFavoriteListPageActions {

    @Test
    @Order(1)
    void Open_Home_Page() {
        Open_Home_Page(page);
    }

    @Test
    @Order(10)
    void Close_Notification_Popup_if_Needed() {
        Close_Notification_Popup_if_Needed(page);
    }

    @Test
    @Order(20)
    void Close_Fortune_Popup_if_Needed() {
        Close_Fortune_Popup_if_Needed(page);
    }

    @Test
    @Order(30)
    void Open_My_Favorite_List_Page() {
        Open_My_Favorite_List_Page(page);
    }

    @Test
    @Order(40)
    void Check_Empty_Favorite_List() {
        Check_Empty_Favorite_List(page);
    }

    @Test
    @Order(50)
    void Search_Product_From_My_Favorite_Page() {
        Search_Product_From_My_Favorite_Page(page);
    }

    @Test
    @Order(60)
    void Add_Product_To_Favorite_list() {
        Add_Product_To_Favorite_list(page);
    }

    @Test
    @Order(70)
    void Open_My_Favorite_List_Page_Second_Time() {
        Open_My_Favorite_List_Page(page);
    }

    @Test
    @Order(80)
    void Check_Not_Empty_Favorite_List() {
        Check_Not_Empty_Favorite_List(page);
    }

    @Test
    @Order(90)
    void Remove_Product_From_Favorite_List() {
        Remove_Product_From_Favorite_List(page);
    }

    @Test
    @Order(100)
    void Check_Empty_Favorite_List_Second_Time() {
        Check_Empty_Favorite_List(page);
    }

    @Override
    String getReportName() {
        return "add-product-to-favorite-list-test";
    }
}
