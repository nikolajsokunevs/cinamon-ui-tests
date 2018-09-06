package smoke;

import config.annotations.Dataset;
import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import meta.Seat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.components.models.SeatsModel;
import ui.components.models.TicketsModel;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Feature("Smoke")
public class SmokeTests extends TestContext {

    @ParameterizedTest(name = "Verify login works properly, language: {0}")
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

    @ParameterizedTest(name = "Verify logout works properly, language: {0}")
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Login")
    @Dataset("Dataset")
    void verifyLogoutWorksProperly(String language) {
        open(language).
                navigateToLoginModel().
                login(data).
                doLogout(data).
                verifyUserIsNotLoggedIn();
    }

    @ParameterizedTest(name = "Verify user can select seats, language: {0}")
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Seats")
    @Dataset("Dataset")
    void verifyUserCanSelectSeats(String language) {

        SeatsModel seatsModel = open(language)
                .selectMovieWithSessionDateInFuture(5)
                .selectTwoAdultTickets()
                .clickNext()
                .selectSeats(2, new int[]{5, 6});

        List<Seat> selectedSeats = seatsModel.getSelectedSeats();

        seatsModel
                .submitYourChoice()
                .verifySeatsWereCorrectlySelected(selectedSeats, data);
    }

    @ParameterizedTest(name = "Verify price is the same at all screens, language: {0}")
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Price")
    @Dataset("Dataset")
    void verifyPriceIsSameAtAllScreens(String language) {
        TicketsModel ticketsModel = open(language)
                .selectMovieWithSessionDateInFuture(10)
                .selectAdultTickets(4);

        String totalPrice = ticketsModel.getTotalPrice();

        ticketsModel
                .clickNext()
                .submitYourChoice()
                .verifyTotalPriceIsCorrect(totalPrice);
    }

    @ParameterizedTest(name = "Verify validation for voucher field, language: {0}")
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Voucher")
    @Dataset("Dataset")
    void verifyValidationForVoucherField(String language) {
        open(language)
                .selectRandomMovie()
                .setVoucherAndPressSubmit(data)
                .verifyVoucherValidationIsTriggered(data);
    }

    @ParameterizedTest(name = "Verify all payment methods are displayed, language: {0}")
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Payment")
    @Dataset("Dataset")
    void verifyAllPaymentMethodsAreDisplayed(String language) {
        open(language)
                .selectRandomMovie()
                .selectAdultTickets(1)
                .clickNext()
                .submitYourChoice()
                .verifyAllPaymentMethodsAreDisplayed(5);
    }

    @ParameterizedTest(name = "Verify user can change order, language: {0}")
    @ValueSource(strings = {"RUS", "LAT", "ENG"})
    @Story("Change order")
    @Dataset("Dataset")
    void verifyUserCanChangeOrder(String language) {
        TicketsModel ticketsModel = open(language)
                .selectRandomMovie()
                .selectAdultTickets(4);

        String totalPrice = ticketsModel.getTotalPrice();

        ticketsModel=ticketsModel
                .clickNext()
                .submitYourChoice()
                .verifyTotalPriceIsCorrect(totalPrice)
                .changeOrder()
                .selectAdultTickets(1);
        String changedPrice = ticketsModel.getTotalPrice();

        ticketsModel
                .clickNext()
                .submitYourChoice()
                .verifyTotalPriceIsCorrect(changedPrice);

        assertNotEquals(totalPrice, changedPrice);
    }
}
