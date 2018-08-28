package ui.components.models;

import com.google.gson.Gson;
import config.webdriver.DriverBase;
import exception.IncorrectTestDataException;
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

    public SeatsModel selectTickets(int ticketsCount, int expectedRow){
        List<Seat> seats=getAllSeatsAsObjects(waitForElements(LBL_ALL_SEATS.get()));
        List<Seat> availableSeats= seats.stream().filter(x->!"Sold".equals(x.getStatus())).collect(Collectors.toList());
        if (availableSeats.size()<ticketsCount){
            throw new IncorrectTestDataException("Incorrect testing data. Not possible select "+ticketsCount+" tickets.");
        }
        List<Seat> seatsInExpectedRow= seats.stream().filter(x->x.getRowId()==expectedRow).collect(Collectors.toList());
        if(seatsInExpectedRow.size()>=ticketsCount){
            clickOnSeats(seatsInExpectedRow, ticketsCount);
        }else {
            clickOnSeats(availableSeats, ticketsCount);
        }
        return this;
    }

    private void clickOnSeats(List<Seat> seats, int expectedRow){
        for(int i=0;i<expectedRow;i++){
            jsClick(By.id(seats.get(i).getElementId()));
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
}
