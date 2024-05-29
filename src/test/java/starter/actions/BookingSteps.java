package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import starter.pages.Homepage;
import starter.pages.ResultPage;

import java.util.Map;

public class BookingSteps {


    Homepage homepage;
    ResultPage resultPage;

    @Step
    public void sally_is_on_the_google_flights_search_website() {
        homepage.open();
        homepage.userOnHomePage();
    }

    public void sally_searches_for_round_trip_flight(Map<String, String> flightDetails){
        homepage.sally_searches_for_round_trip_flight(flightDetails);
    }

    public void sally_should_see_flights_results_page_with(String string) {
        resultPage.sally_should_see_flights_results_page_with(string);
    }

    public void sally_selects_the_first_flight_under_best_flights() {
        resultPage.sally_selects_the_first_flight_under_best_flights();
    }

    public void sally_should_see_the_corresponding_flight_information_for_flights_selected() {
        resultPage.sally_should_see_the_corresponding_flight_information_for_flights_selected();
    }

    public void sally_searches_for_multi_city_flight(Map<String, String> flightDetails) {
        homepage.sally_searches_for_multi_city_flight(flightDetails);
    }



}
