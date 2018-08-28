package ui.components.models;

import utils.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.TicketsPage.*;

public class TicketsModel extends MainModel {

    public TicketsModel(String languagePrefix) {
        super(languagePrefix);
    }

    public TicketsModel selectTwoAdultTickets(){
        selectAdultTickets(2);
        return this;
    }

    public TicketsModel selectAdultTickets(int ticketCount){
        scrollToElement(BTN_ADD_ADULT_TICKET_PLUS.get());
        for(int i=0; i<ticketCount;i++){
            click(BTN_ADD_ADULT_TICKET_PLUS.get());
        }
        return this;
    }

    public TicketsModel setVoucherAndPressSubmit(DataProvider data){
        sendKeys(TXT_VOUCHER.get(), data.getData("voucher"));
        click(BTN_VOUCHER_SEND.get());
        return this;
    }

    public TicketsModel verifyVoucherValidationIsTriggered(DataProvider data){
        assertEquals(getText(LBL_VOUCHER_ERROR.get()), data.getData(languagePrefix,"voucher.error"));
        return this;
    }

    public SeatsModel clickNext(){
        click(BTN_NEXT.get());
        return new SeatsModel(languagePrefix);
    }

    public String getTotalPrice(){
        return getText(LBL_TOTAL_PRICE.get());
    }

}
