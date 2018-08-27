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
        this.languagePrefix = languagePrefix.toLowerCase();
    }

    static {
        if(isElementDisplayed(BTN_ACCEPT_COOKIES.get())){
            click(BTN_ACCEPT_COOKIES.get());
        }
    }

    @Step
    public MainModel changeLanguage() {
              return this;
    }
}
