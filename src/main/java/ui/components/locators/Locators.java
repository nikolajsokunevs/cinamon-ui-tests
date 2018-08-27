package ui.components.locators;

import org.openqa.selenium.By;
import java.util.function.Function;
import static java.lang.String.format;

public interface Locators {

    enum MainPage implements Locators{

        BTN_NO_NEW_VERSION_PROMO(By::cssSelector, "#promo-text a"),
        BTN_CURRENT_LANGUAGES(By::cssSelector, "#langmenu li.active a"),
        BTN_LANGUAGE(By::xpath, "//ul[@id='langmenu']/li/a[text()='%s']");

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
