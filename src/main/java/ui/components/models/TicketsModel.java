package ui.components.models;

import io.qameta.allure.Step;
import utils.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.TicketsPage.*;

public class TicketsModel extends MainModel {

    public TicketsModel(String languagePrefix) {
        super(languagePrefix);
    }

    @Step
    public TicketsModel selectTwoAdultTickets(){
        selectAdultTickets(2);
        return this;
    }

    @Step
    public TicketsModel selectAdultTickets(int ticketCount){
        scrollToElement(BTN_ADD_ADULT_TICKET_PLUS.get());
        for(int i=0; i<ticketCount;i++){
            click(BTN_ADD_ADULT_TICKET_PLUS.get());
        }
        return this;
    }

    @Step
    public TicketsModel setVoucherAndPressSubmit(DataProvider data){
        sendKeys(TXT_VOUCHER.get(), data.getData("voucher"));
        click(BTN_VOUCHER_SEND.get());
        return this;
    }

    @Step
    public TicketsModel verifyVoucherValidationIsTriggered(DataProvider data){
        assertEquals(getText(LBL_VOUCHER_ERROR.get()), data.getData(languagePrefix,"voucher.error"));
        return this;
    }

    @Step
    public SeatsModel clickNext(){
        click(BTN_NEXT.get());
        return new SeatsModel(languagePrefix);
    }

    public String getTotalPrice(){
        return getText(LBL_TOTAL_PRICE.get());
    }

}
