package smoke;

import config.annotations.Dataset;
import context.TestContext;
import dto.SearchResultItem;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

@Feature("Smoke")
public class FirstTests extends TestContext {

    @ParameterizedTest
    //@ValueSource(strings = {"RUS", "LAT", "ENG"})
    @ValueSource(strings = {"RUS"})
    @Story("SomeStory")
    @Dataset("Dataset")
    void verifyUserIsSelect(String language) {
        open(language);
    }
}
