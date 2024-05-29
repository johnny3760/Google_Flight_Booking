package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.FindBy;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static starter.utilities.Util.*;

public class Homepage extends PageObject{
    @FindBy(xpath = "//div[@data-hveid='CAMQBA']//div[@class='RLVa8 GeHXyb']")
    private WebElementFacade tripSelection;
    @FindBy(xpath = "//div[@data-hveid='CAMQBA']//div[@class='RLVa8 GeHXyb']//li[@data-value='1']")
    private WebElementFacade roundtrip;
    @FindBy(xpath = "//div[@data-hveid='CAMQBA']//div[@class='RLVa8 GeHXyb']//li[@data-value='3']")
    private WebElementFacade multiTrip;
    @FindBy(xpath = "(//input[contains(@aria-label, 'Where from?')])[1]")
    private WebElementFacade originOnRoundTrip;
    @FindBy(xpath = "(//input[contains(@aria-label, 'Where from?')])[2]")
    private WebElementFacade originOnMultiTrip;
    @FindBy(xpath = "(//input[contains(@aria-label, 'Where to?')])[1]")
    private WebElementFacade whereToInputOnRoundTrip;
    @FindBy(xpath = "(//input[contains(@aria-label, 'Where to?')])[2]")
    private WebElementFacade whereToInput1;
    @FindBy(xpath = "(//input[contains(@aria-label, 'Where to?')])[3]")
    private WebElementFacade whereToInput2;
    @FindBy(xpath = "(//input[contains(@aria-label, 'Where to?')])[4]")
    private WebElementFacade whereToInput3;
    @FindBy(xpath = "(//input[@jsname='yrriRe'])[5]")
    private WebElementFacade departureDateInput;
    @FindBy(xpath = "(//input[@aria-label='Departure'])[3]")
    private WebElementFacade destinationDateInputForMultiTrip1;
    @FindBy(xpath = "(//input[@aria-label='Departure'])[5]")
    private WebElementFacade destinationDateInputForMultiTrip2;
    @FindBy(xpath = "(//input[@aria-label='Departure'])[7]")
    private WebElementFacade destinationDateInputForMultiTrip3;
    @FindBy(xpath = "(//input[@jsname='yrriRe'])[5]")
    private WebElementFacade departureDateInput_2;
    @FindBy(xpath = "(//input[@jsname='yrriRe'])[6]")
    private WebElementFacade returnDateInput;
    @FindBy(xpath = "(//input[@placeholder='Return'])[2]")
    private WebElementFacade returnDateInput_2;
    @FindBy(xpath = "(//span[contains(text(), 'Search') or contains(text(), 'Explore')])[2]")
    private WebElementFacade exploreButton;
    @FindBy(xpath = "(//span[.='Done'])[4]")
    private WebElementFacade doneButton;
    @FindBy(xpath = "(//span[contains(text(), 'Done')])[3]")
    private WebElementFacade doneButton1;
    @FindBy(xpath = "(//span[contains(text(), 'Done')])[4]")
    private WebElementFacade doneButton2;
    @FindBy(xpath = "(//span[contains(text(), 'Done')])[5]")
    private WebElementFacade doneButton3;
    @FindBy(xpath = "(//ul[@role='listbox'])[3]/li[1]")
    private WebElementFacade firstElementInDestinationList;
    @FindBy(xpath = "(//ul[@role='listbox'])[4]/li[1]")
    private WebElementFacade firstElementInSecondDestinationList;
    @FindBy(xpath = "//span[.='Add flight']")
    private WebElementFacade addFlightButton;

    public void userOnHomePage(){
        String title = getDriver().getTitle();
        assertEquals(title,"Google Flights - Find Cheap Flight Options & Track Prices");
    }

    public void sally_searches_for_round_trip_flight(Map<String, String> flightDetails){
        waitFor(tripSelection).click();
        waitFor(roundtrip).click();
        waitABit(2000);

        String origin = flightDetails.get("Origin");
        originOnRoundTrip.type(origin);
        selectAndConfirm(firstElementInDestinationList,origin);

        String destination = flightDetails.get("Destination");
        whereToInputOnRoundTrip.type(destination);
        selectAndConfirm(firstElementInDestinationList,destination);
        waitABit(1000);
        String futureDateForDeparture = dateTransfer(flightDetails.get("Departure Day"));
        departureDateInput_2.click();
        getDriver().findElement(By.xpath(String.format("//div[@aria-label='%s']", futureDateForDeparture))).click();
        waitABit(1000);
        String futureDateForReturn = dateTransfer(flightDetails.get("Return Day"));
        getDriver().findElement(By.xpath(String.format("//div[@aria-label='%s']", futureDateForReturn))).click();
        doneButton.click();
        waitABit(1000);
        waitFor(exploreButton).click();
    }

    public void sally_searches_for_multi_city_flight(Map<String, String> flightDetails) {
        waitFor(tripSelection).click();
        waitFor(multiTrip).click();

        String origin = flightDetails.get("Origin");
        originOnMultiTrip.type(origin);
        selectAndConfirm(firstElementInSecondDestinationList, origin);

        String destination1 = flightDetails.get("Destination 1");
        whereToInput1.type(destination1);
        selectAndConfirm(firstElementInSecondDestinationList, destination1);

        String futureDateForDeparture1 = dateTransfer(flightDetails.get("Departure Day 1"));
        destinationDateInputForMultiTrip1.click();
        waitABit(1000);
        getDriver().findElement(By.xpath(String.format("(//div[@aria-label='%s'])[2]", futureDateForDeparture1))).click();
        doneButton1.click();

        String destination2 = flightDetails.get("Destination 2");
        whereToInput2.type(destination2);
        selectAndConfirm(firstElementInSecondDestinationList, destination2);

        String futureDateForDeparture2 = dateTransfer(flightDetails.get("Departure Day 2"));
        destinationDateInputForMultiTrip2.click();
        waitABit(1000);
        getDriver().findElement(By.xpath(String.format("(//div[@aria-label='%s'])[3]", futureDateForDeparture2))).click();
        doneButton2.click();

        waitFor(addFlightButton).click();

        String destination3 = flightDetails.get("Destination 3");
        whereToInput3.type(destination3);
        selectAndConfirm(firstElementInSecondDestinationList, destination3);

        String futureDateForDeparture3 = dateTransfer(flightDetails.get("Departure Day 3"));
        destinationDateInputForMultiTrip3.click();
        waitABit(1000);
        getDriver().findElement(By.xpath(String.format("(//div[@aria-label='%s'])[4]", futureDateForDeparture3))).click();
        doneButton3.click();

        waitABit(2000);
        exploreButton.click();
    }

    public void selectAndConfirm(WebElementFacade webElementFacade, String placeName){
        waitForCondition()
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> webElementFacade.isCurrentlyVisible());
        if(webElementFacade.getAttribute("aria-label").contains(placeName)){
            webElementFacade.click();
        }
    }

    public String dateTransfer(String departureDay){
        int daysToAddForDeparture = extractDaysFromString(departureDay);
        String futureDateForDeparture = getCurrentDatePlusDays(daysToAddForDeparture);
        return convertDate(futureDateForDeparture);
    }




}
