package ui.components.locators;

import org.openqa.selenium.By;
import java.util.function.Function;
import static java.lang.String.format;

public interface Locators {

    enum MainPage implements Locators{

        BTN_ACCEPT_COOKIES(By::cssSelector, "#cookie_confirm_body button"),
        LNK_LANGUAGE(By::cssSelector, ".menu_lang>a.a_menu");

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
}
