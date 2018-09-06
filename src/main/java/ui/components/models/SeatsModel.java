package ui.components.models;

import com.google.gson.Gson;
import exception.IncorrectTestDataException;
import io.qameta.allure.Step;
import meta.Seat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static ui.components.locators.Locators.SeatsPage.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static support.web.WebElementHelper.*;

public class SeatsModel extends MainModel{

    public SeatsModel(String languagePrefix) {
        super(languagePrefix);
    }

    private List<Seat> selectedSeats=new ArrayList<>();

    @Step
    public List<Seat> getSelectedSeats(){
        return selectedSeats;
    }

    @Step
    public SeatsModel selectSeats(int ticketsCount, int[] desirableRows){
        List<Seat> availableSeats= getAllSeatsAsObjects(waitForElements(LBL_ALL_SEATS.get()))
                .stream().filter(x->!"Sold".equals(x.getStatus())).collect(Collectors.toList());
        if (availableSeats.size()<ticketsCount){
            throw new IncorrectTestDataException("Incorrect testing data. Not possible select "+ticketsCount+" tickets.");
        }


        for(int currentRow:desirableRows){
            List<Seat> seatsInRow=seatsAvailableInRow(availableSeats, currentRow);
            if (seatsInRow.size()>=ticketsCount){
                clickOnSeats(seatsInRow, ticketsCount);
                return this;
            }
        }
        clickOnSeats(availableSeats, ticketsCount);
        return this;
    }

    @Step
    public PaymentModel submitYourChoice(){
        click(BTN_SUBMIT.get());
        return new PaymentModel(languagePrefix);
    }

    private void clickOnSeats(List<Seat> seats, int ticketsCount){
        for(int i=0;i<ticketsCount;i++){
            selectedSeats.add(seats.get(i));
            scrollToElement(By.id(seats.get(i).getElementId()));
            actionClick(By.id(seats.get(i).getElementId()));
        }
    }

    private List<Seat> getAllSeatsAsObjects(List<WebElement> allSeatsAsWebElements){
        List<Seat> allSeatsAsObjects=new ArrayList<>();
        for(WebElement current:allSeatsAsWebElements){
            Seat seat= new Gson().fromJson(current.getAttribute("seatmeta"), Seat.class);
            allSeatsAsObjects.add(seat);
        }
        return allSeatsAsObjects;
    }

    private List<Seat> seatsAvailableInRow(List<Seat> seats, int expectedRow){
        return seats.stream().filter(x->x.getRowId()==expectedRow).collect(Collectors.toList());
    }
}
