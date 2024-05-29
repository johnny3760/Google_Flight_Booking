package starter.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultPage extends PageObject {

    @FindBy(xpath = "(//h3)[1]")
    private WebElementFacade bestFlightsHeader;

    @FindBy(xpath = "//h2[.='Booking options']")
    private WebElementFacade bookingOptionsHeader;

    @FindBy(xpath = "(//ul[@class='Rk10dc']//li)[1]")
    private WebElementFacade firstFlightOnTheList;

//    @FindAll({@FindBy(xpath = "//div[@jsname='IWWDBc']//li")})
//    private List<WebElementFacade> bestFlightList;

    @FindAll({@FindBy(xpath = "//div[@role='listitem']")})
    private List<WebElementFacade> flightsSelectedList;

    @FindBy(xpath = "(//h2)[1]")
    private WebElementFacade flightsSelectedListHeader;

    @FindBy(xpath = "//div[@class='ogfYpf AdWm1c']")
    private WebElementFacade selectedAirlineDetails;

    public void sally_should_see_flights_results_page_with(String string) {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> bestFlightsHeader.waitUntilVisible());
        if(bestFlightsHeader.isCurrentlyVisible()){
            if(bestFlightsHeader.getText().equalsIgnoreCase(string)){
                assertEquals(string, bestFlightsHeader.getText());
            }else{
                System.out.println("Actual Text is: " + bestFlightsHeader.getText());
            }
        }
        waitABit(3000);
        if(bookingOptionsHeader.isCurrentlyVisible()){
            assertEquals(string, bookingOptionsHeader.getText());
        }
    }

    public void sally_selects_the_first_flight_under_best_flights() {
        firstFlightOnTheList.waitUntilClickable();
        firstFlightOnTheList.click();
        System.out.println("First best flight selected");
    }

    public void sally_should_see_the_corresponding_flight_information_for_flights_selected() {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> flightsSelectedListHeader.waitUntilVisible());
        System.out.println(flightsSelectedListHeader.getText());
        assertTrue(flightsSelectedListHeader.isDisplayed());
        waitABit(5000);
        flightsSelectedList.forEach(element ->
                element.findElements(By.xpath("//div[@class='zxVSec YMlIz tPgKwe ogfYpf']/span"))
                        .forEach(nestedElement -> System.out.println(nestedElement.getAttribute("aria-label"))));
    }






}
