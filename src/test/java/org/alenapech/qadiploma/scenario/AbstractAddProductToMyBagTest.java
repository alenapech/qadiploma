package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.alenapech.qadiploma.action.MyBagPageActions;
import org.alenapech.qadiploma.action.ProductPageActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Add Product To My Bag Test")
public abstract class AbstractAddProductToMyBagTest extends AbstractTest implements HomePageActions, MyBagPageActions, ProductPageActions {

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
    void Open_My_Bag_Page() {
        Open_My_Bag_Page(page);
    }

    @Test
    @Order(40)
    void Check_Empty_Bag() {
        Check_Empty_Bag(page);
    }

    @Test
    @Order(50)
    void Search_Product_From_My_Bag_Page() {
        Search_Product_From_My_Bag_Page(page);
    }

    @Test
    @Order(60)
    void Open_Product_Page() {
        Open_Product_Page(page);
    }

    @Test
    @Order(70)
    void Add_Product_To_My_Bag() {
        Add_Product_To_My_Bag(page);
    }

    @Test
    @Order(80)
    void Open_My_Bag_Page_Second_Time() {
        Open_My_Bag_Page(page);
    }

    @Test
    @Order(90)
    void Check_Not_Empty_Bag() {
        Check_Not_Empty_Bag(page);
    }

    @Test
    @Order(100)
    void Delete_Product_From_Bag() {
        Delete_Product_From_Bag(page);
    }

    @Override
    String getReportName() {
        return "add-product-to-my-bag";
    }
}
