package ui.components.models;

import io.qameta.allure.Step;
import utils.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.LoginPage.*;
import static ui.components.locators.Locators.MainPage.BTN_LOGOUT;

public class LoginModel extends MainModel {

    public LoginModel(String languagePrefix) {
        super(languagePrefix);
    }

    @Step
    public MainModel login(DataProvider data){
        sendKeys(TXT_USERNAME.get(), data.getData("login"));
        sendKeys(TXT_PASSWPRD.get(), data.getData("password"));
        scrollToElement(BTN_LOGIN.get());
        click(BTN_LOGIN.get());
        //assertTrue(isElementDisplayed(LBL_LOGIN_INFO.get(data.getData(languagePrefix, "login.info"))));
        waitForElement(BTN_LOGOUT.get());
        return new MainModel(languagePrefix);
    }

    @Step
    public MainModel verifyUserDetails(DataProvider data){
        assertEquals(data.getData("firstName"), getText(TXT_FIRSTNAME.get()));
        assertEquals(data.getData("lastName"), getText(TXT_LASTNAME.get()));
        assertEquals(data.getData("phone"), getText(TXT_PHONE.get()));
        assertEquals(data.getData("login"), getText(TXT_EMAIL.get()));
        return this;
    }
}
