package ui.components.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.web.WebElementHelper.*;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DataProvider;

import static ui.components.locators.Locators.MainPage.*;

public class MainModel {

    private static final Logger logger = LoggerFactory.getLogger(MainModel.class);
    protected String languagePrefix = "";

    public MainModel(String languagePrefix) {
        this.languagePrefix = languagePrefix.toUpperCase();
    }

    @Step
    public MainModel changeLanguage() {
        executeJS("document.cookie='promo=true;; expires=Mon, 27 Aug 2019 18:34:53 GMTpath=/'");
        click(BTN_CLOSE_NEW_VERSION_PROMO.get());
        if (!this.languagePrefix.equals(getText(BTN_CURRENT_LANGUAGES.get()))){
            click(BTN_LANGUAGE.get(this.languagePrefix));
        }
        return this;
    }

    @Step
    public LoginModel navigateToLoginModel(){
        click(LNK_LOGIN.get());
        return new LoginModel(languagePrefix);
    }
    

    @Step
    public MainModel doLogout(){
        click(BTN_LOGOUT.get());
        waitForInivsibilityOfElement(BTN_LOGOUT.get());
        return this;
    }

    @Step
    public MainModel verifyUserIsLoggedIn(DataProvider data){
        assertTrue(isElementDisplayed(BTN_LOGOUT.get()), "Logout button is not displayed");
        assertEquals(data.getData("fullName"), getText(LNK_LOGIN.get()));
        return this;
    }

    @Step
    public MainModel verifyUserIsNotLoggedIn(){
        assertFalse(isElementDisplayed(BTN_LOGOUT.get()), "Logout button is display");
        return this;
    }
}
