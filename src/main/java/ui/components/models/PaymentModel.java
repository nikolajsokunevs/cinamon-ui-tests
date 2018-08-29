package ui.components.models;

import io.qameta.allure.Step;
import meta.Seat;
import org.openqa.selenium.By;
import utils.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.PaymentPage.*;

public class PaymentModel extends MainModel {

    public PaymentModel(String languagePrefix) {
        super(languagePrefix);
    }

    @Step
    public PaymentModel verifySeatsWereCorrectlySelected(List<Seat> seats, DataProvider data) {
        Map<Integer, List<Seat>> seatsGroupedByRow = seats.stream().collect(
                Collectors.groupingBy(Seat::getRowId, Collectors.toList()));

        for (Map.Entry<Integer, List<Seat>> entry : seatsGroupedByRow.entrySet()) {
            String expectedString = data.getData(languagePrefix, "row.seat");
            List<String> seatNumbers = new ArrayList<>();
            entry.getValue().stream().forEach(x -> seatNumbers.add(x.getId()));
            expectedString = format(expectedString, entry.getKey(), String.join(", "
                    , seatNumbers.stream().sorted().collect(Collectors.toList())));
            assertTrue(isElementDisplayed(By.xpath(format("//td[contains(.,'%s')]", expectedString))), format("Text '%s' wasn't displayed", expectedString));
        }
        return this;
    }

    @Step
    public PaymentModel verifyTotalPriceIsCorrect(String expectedPrice) {
        String actualPrice = getText(LBL_TOTAL_PRICE.get());
        assertEquals(expectedPrice, actualPrice);
        return this;
    }

    @Step
    public PaymentModel verifyAllPaymentMethodsAreDisplayed(int expectedPaymentMethodCount) {
        assertEquals(expectedPaymentMethodCount, waitForElements(LBL_PAYMENT_METHODS.get()).size());
        return this;
    }

    @Step
    public TicketsModel changeOrder(){
        click(BTN_CHANGE_OREDER.get());
        return new TicketsModel(languagePrefix);
    }
}
