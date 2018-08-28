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
public class SmokeTests extends TestContext {

    @ParameterizedTest
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Login")
    @Dataset("Dataset")
    void verifyLoginWorksProperly(String language) {
        open(language).
                navigateToLoginModel().
                login(data).
                verifyUserIsLoggedIn(data).
                navigateToLoginModel().
                verifyUserDetails(data);
    }

    @ParameterizedTest
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Logout")
    @Dataset("Dataset")
    void verifyLogoutWorksProperly(String language) {
        open(language).
                navigateToLoginModel().
                login(data).
                doLogout().
                verifyUserIsNotLoggedIn();
    }
}
