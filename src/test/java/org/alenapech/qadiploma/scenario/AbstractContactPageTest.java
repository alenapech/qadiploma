package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public abstract class AbstractContactPageTest extends AbstractTest implements HomePageActions {

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
    void Open_Contact_Page() {
        Open_Contact_Page(page);
    }

    @Override
    String getReportName() {
        return "contact-page-test";
    }
}
