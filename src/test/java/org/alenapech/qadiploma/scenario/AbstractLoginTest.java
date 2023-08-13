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
    @Order(2)
    void Close_Popup_if_Needed() {
        Close_Popup_if_Needed(page);
    }

    @Test
    @Order(3)
    void Show_Account_Actions_Dropdown_List() {
        Show_Account_Actions_Dropdown_List(page);
    }

    @Test
    @Order(4)
    void Open_Login_Form() {
        Open_Login_Page(page);
    }

    @Test
    @Order(5)
    void Click_Login_Button() {
        Click_Login_Button(page);
    }

    @Test
    @Order(6)
    void Check_Validation_for_Empty_CAPTCHA() {
        Check_Validation_for_Empty_CAPTCHA(page);
    }

    @Test
    @Order(7)
    void Check_Validation_for_Empty_Password() {
        Check_Validation_for_Empty_Password(page);
    }

    @Test
    @Order(8)
    void Check_Validation_for_Empty_Mail() {
        Check_Validation_for_Empty_Mail(page);
    }

    @Test
    @Order(9)
    void Check_Validation_for_Incorrect_Mail() {
        Check_Validation_for_Incorrect_Mail(page);
    }

    @Override
    String getReportName() {
        return "login-test";
    }
}
