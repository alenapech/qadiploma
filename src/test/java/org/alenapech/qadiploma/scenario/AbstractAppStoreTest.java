package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("App Store Test")
public abstract class AbstractAppStoreTest extends AbstractTest implements HomePageActions {

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
    void Open_App_Store_Page() {
        Open_App_Store_Page(page);
    }

    @Override
    String getReportName() {
        return "app-store-test";
    }
}
