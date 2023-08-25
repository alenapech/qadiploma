package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.GlobalPageActions;
import org.alenapech.qadiploma.action.HomePageActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Change Locale Test")
public abstract class AbstractChangeLocaleTest extends AbstractTest implements HomePageActions, GlobalPageActions {

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
    void Open_Global_Page() {
        Open_Global_Page(page);
    }

    @Test
    @Order(40)
    void Change_Local_To_Italy() {
        Change_Local_To_Italy(page);
    }

    @Test
    @Order(50)
    void Accept_Italy_Location() {
        Accept_Italy_Location(page);
    }

    @Override
    String getReportName() {
        return "change-locale-test";
    }
}
