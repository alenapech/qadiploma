package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Search Product Test")
public abstract class AbstractSearchProductTest extends AbstractTest implements HomePageActions {

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
    void Search_Product() {
        Search_Product(page);
    }

//    @Test
//    @Order(40)
//    void Open_Product_Quick_Details() {
//        Open_Product_Quick_Details(page);
//    }
//
//    @Test
//    @Order(50)
//    void Open_Product_Page_From_Quick_Details() {
//        Open_Product_Page_From_Quick_Details(page);
//    }

    @Test
    @Order(40)
    void Open_Product_Page() {
        Open_Product_Page(page);
    }

    @Override
    String getReportName() {
        return "search-product-test";
    }
}
