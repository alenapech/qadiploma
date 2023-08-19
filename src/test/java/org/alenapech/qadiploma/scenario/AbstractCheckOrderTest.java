package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.alenapech.qadiploma.action.SearchOrderPageActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Check Order Test")
public abstract class AbstractCheckOrderTest extends AbstractTest implements HomePageActions, SearchOrderPageActions {

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
    void Open_Search_Order_From_Header_Page() {
        Open_Search_Order_From_Header_Page(page);
    }

    @Test
    @Order(40)
    void Open_Home_Page_Second_Time() {
        Open_Home_Page(page);
    }

    @Test
    @Order(50)
    void Close_Fortune_Popup_if_Needed_Second_Time() {
        Close_Fortune_Popup_if_Needed(page);
    }

    @Test
    @Order(60)
    void Open_Search_Order_From_Footer_Page() {
        Open_Search_Order_From_Footer_Page(page);
    }

    @Test
    @Order(70)
    void Click_Search_Button() {
        Click_Search_Button(page);
    }

    @Test
    @Order(80)
    void Check_Validation_for_Empty_Mail() {
        Check_Validation_for_Empty_Mail(page);
    }

    @Test
    @Order(90)
    void Check_Validation_for_Empty_Order() {
        Check_Validation_for_Empty_Order(page);
    }

    @Test
    @Order(100)
    void Check_Validation_for_Incorrect_Mail() {
        Check_Validation_for_Incorrect_Mail(page);
    }

    @Test
    @Order(110)
    void Check_Validation_for_Incorrect_Order() {
        Check_Validation_for_Incorrect_Order(page);
    }

    @Test
    @Order(120)
    void Open_Order_Details_Page() {
        Open_Order_Details_Page(page);
    }

    @Override
    String getReportName() {
        return "check-order-test";
    }

}
