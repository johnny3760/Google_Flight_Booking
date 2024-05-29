package starter.stepdifinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.actions.BookingSteps;

import java.util.List;
import java.util.Map;

public class BookingStepdefs {

    @Steps
    BookingSteps bookingSteps;

    @Given("Sally is on the google flights search website")
    public void sally_is_on_the_google_flights_search_website() {
        bookingSteps.sally_is_on_the_google_flights_search_website();
    }
    @When("Sally searches for round trip flight")
    public void sally_searches_for_round_trip_flight_with_details(Map<String, String> flightDetails) {
        bookingSteps.sally_searches_for_round_trip_flight(flightDetails);
    }
    @Then("Sally should see flights results page with {string}")
    public void sally_should_see_flights_results_page_with(String string) {
       bookingSteps.sally_should_see_flights_results_page_with(string);
    }
    @When("Sally selects the first flight under best flights")
    public void sally_selects_the_first_flight_under_best_flights() {
        bookingSteps.sally_selects_the_first_flight_under_best_flights();
    }
    @Then("Sally should see the corresponding flight information for flights selected")
    public void sally_should_see_the_corresponding_flight_information_for_flights_selected() {
        bookingSteps.sally_should_see_the_corresponding_flight_information_for_flights_selected();
    }

    @When("Sally searches for multi-city flight")
    public void sally_searches_for_multi_city_flight(Map<String, String> flightDetails) {
        bookingSteps.sally_searches_for_multi_city_flight(flightDetails);
    }

}
