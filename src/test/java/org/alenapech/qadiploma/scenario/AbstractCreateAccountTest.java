package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.CreateAccountPageActions;
import org.alenapech.qadiploma.action.HomePageActions;
import org.junit.jupiter.api.*;

@DisplayName("Create Account Test")
public abstract class AbstractCreateAccountTest extends AbstractTest implements HomePageActions, CreateAccountPageActions {
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
    void Show_Account_Actions_Dropdown_List() {
        Show_Account_Actions_Dropdown_List(page);
    }

    @Test
    @Order(40)
    void Open_Account_Creation_Form() {
        Open_Account_Creation_Page(page);
    }

    @Test
    @Order(50)
    void Click_Account_Creation_Button() {
        Click_Account_Creation_Button(page);
    }

    @Test
    @Order(60)
    void Check_Validation_for_Empty_CAPTCHA() {
        Check_Validation_for_Empty_CAPTCHA(page);
    }

    @Test
    @Order(70)
    void Check_Validation_for_Empty_Phone() {
        Check_Validation_for_Empty_Phone(page);
    }

    @Test
    @Order(80)
    void Check_Validation_for_Empty_Password() {
        Check_Validation_for_Empty_Password(page);
    }

    @Test
    @Order(90)
    void Check_Validation_for_Empty_Mail() {
        Check_Validation_for_Empty_Mail(page);
    }

    @Test
    @Order(100)
    void Check_Validation_for_Incorrect_Password() {
        Check_Validation_for_Incorrect_Password(page);
    }

    @Test
    @Order(110)
    void Check_Validation_for_Incorrect_Mail() {
        Check_Validation_for_Incorrect_Mail(page);
    }

    @Override
    String getReportName() {
        return "create-account-test";
    }
}
