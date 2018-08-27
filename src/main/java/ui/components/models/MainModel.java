package ui.components.models;

import static support.web.WebElementHelper.*;
import static utils.Utils.*;

import exception.IncorrectTestDataException;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ui.components.locators.Locators.MainPage.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainModel {

    private static final Logger logger = LoggerFactory.getLogger(MainModel.class);
    protected String languagePrefix = "";

    public MainModel(String languagePrefix) {
        this.languagePrefix = languagePrefix.toUpperCase();
    }

    static {
        if(isElementDisplayed(BTN_NO_NEW_VERSION_PROMO.get())){
            click(BTN_NO_NEW_VERSION_PROMO.get());
        }
    }

    @Step
    public MainModel changeLanguage() {
        if (!this.languagePrefix.equals(getText(BTN_CURRENT_LANGUAGES.get()))){
            click(BTN_LANGUAGE.get(this.languagePrefix));
        }
        return this;
    }

}
