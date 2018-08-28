package ui.components.models;
import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.TicketsPage.*;

public class TicketsModel extends MainModel {

    public TicketsModel(String languagePrefix) {
        super(languagePrefix);
    }

    public SeatsModel selectTwoAdultTickets(){
        scrollToElement(BTN_ADD_ADULT_TICKET_PLUS.get());
        click(BTN_ADD_ADULT_TICKET_PLUS.get());
        click(BTN_ADD_ADULT_TICKET_PLUS.get());
        click(BTN_NEXT.get());
        return new SeatsModel(languagePrefix);
    }

}
