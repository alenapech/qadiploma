package org.alenapech.qadiploma.scenario;

import org.alenapech.qadiploma.action.HomePageActions;
import org.alenapech.qadiploma.action.LoginPageActions;
import org.junit.jupiter.api.*;

@DisplayName("Login Test")
public abstract class AbstractLoginTest extends AbstractTest implements HomePageActions, LoginPageActions {

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
    void Open_Login_Form() {
        Open_Login_Page(page);
    }

    @Test
    @Order(50)
    void Click_Login_Button() {
        Click_Login_Button(page);
    }

    @Test
    @Order(60)
    void Check_Validation_for_Empty_CAPTCHA() {
        Check_Validation_for_Empty_CAPTCHA(page);
    }

    @Test
    @Order(70)
    void Check_Validation_for_Empty_Password() {
        Check_Validation_for_Empty_Password(page);
    }

    @Test
    @Order(80)
    void Check_Validation_for_Empty_Mail() {
        Check_Validation_for_Empty_Mail(page);
    }

    @Test
    @Order(90)
    void Check_Validation_for_Incorrect_Mail() {
        Check_Validation_for_Incorrect_Mail(page);
    }

    @Override
    String getReportName() {
        return "login-test";
    }
}
