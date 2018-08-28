package ui.components.locators;

import org.openqa.selenium.By;

import java.util.function.Function;

import static java.lang.String.format;

public interface Locators {

    enum MainPage implements Locators {

        BTN_NO_NEW_VERSION_PROMO(By::cssSelector, "#promo-text a"),
        BTN_CLOSE_NEW_VERSION_PROMO(By::cssSelector, "a.close-reveal-modal"),
        BTN_CURRENT_LANGUAGES(By::cssSelector, "#langmenu li.active a"),
        BTN_LANGUAGE(By::xpath, "//ul[@id='langmenu']/li/a[text()='%s']"),
        LNK_LOGIN(By::cssSelector, ".login-area .username"),
        BTN_LOGOUT(By::cssSelector, ".login-area .logout"),
        LNK_LOGIN_BY_NAME(By::xpath, "//div[@class='login-area']/a[text()='%s']"),
        LNK_SESSION_DATE(By::cssSelector, "div.sessions-cell>div>div"),
        LNL_SESSION_LINK(By::cssSelector, "div.session-item>a");

        private String id;
        private Function<String, By> function;

        MainPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }

    enum LoginPage implements Locators {
        TXT_FIRSTNAME(By::id, "firstname"),
        TXT_LASTNAME(By::id, "lastname"),
        TXT_PHONE(By::name, "telephone"),
        TXT_EMAIL(By::name, "email"),
        TXT_USERNAME(By::name, "username"),
        TXT_PASSWPRD(By::name, "password"),
        LBL_LOGIN_INFO(By::xpath, "//p[contains(.,'%s')]"),
        BTN_LOGIN(By::xpath, "//button[@type='submit']");

        private String id;
        private Function<String, By> function;

        LoginPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }

    enum TicketsPage implements Locators {
        BTN_ADD_ADULT_TICKET_PLUS(By::xpath, "//form[@id='ticket_form']/table/tbody/tr[2]/td/input[@type='button'][@value='+']"),
        BTN_ADD_ADULT_TICKET_MINUS(By::xpath, "//form[@id='ticket_form']/table/tbody/tr[2]/td/input[@type='button'][@value='-']"),
        LBL_ADULT_TICKET_PRICE(By::xpath, "//form[@id='ticket_form']/table/tbody/tr[2]/td[last()]"),
        BTN_NEXT(By::id, "next-step"),
        LBL_TOTAL_PRICE(By::cssSelector, "td.total"),
        TXT_VOUCHER(By::cssSelector, ".voucher input"),
        BTN_VOUCHER_SEND(By::cssSelector, ".voucher button"),
        LBL_VOUCHER_ERROR(By::cssSelector, ".voucher small.error"),;

        private String id;
        private Function<String, By> function;

        TicketsPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }

    enum SeatsPage implements Locators {
        LBL_ALL_SEATS(By::cssSelector, "#seatplan g"),
        BTN_SUBMIT(By::name, "submit"),;

        private String id;
        private Function<String, By> function;

        SeatsPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }

    enum PaymentPage implements Locators {
        LBL_TOTAL_PRICE(By::cssSelector, "td.total"),
        BTN_CHANGE_OREDER(By::cssSelector, "tfoot a.change-btn"),
        LBL_PAYMENT_METHODS(By::cssSelector, ".payment-methods li");

        private String id;
        private Function<String, By> function;

        PaymentPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }
}
