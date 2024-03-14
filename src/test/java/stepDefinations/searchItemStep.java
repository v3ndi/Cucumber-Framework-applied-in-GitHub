package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import setup.Setup;

public class searchItemStep extends Setup {
    LandingPage landingPage=new LandingPage(webDriver);

    @Given("user visits the site as guest \\(not logged in)")
    public void user_visits_the_site_as_guest_not_logged_in() {
        webDriver.get("https://github.com/");
    }
    @When("The user wants to search for the term {string} from the landing page search field")
    public void the_user_wants_to_search_for_the_term_from_the_landing_page_search_input(String string) throws InterruptedException {
        landingPage.passingSearchKeyWord(string);
    }
    @When("initiates the search")
    public void initiates_the_search() {
        landingPage.pressEnter();
    }
    @Then("A count of matching results should be displayed")
    public void a_count_of_matching_results_should_be_displayed() {
        landingPage.assertResultText();
    }

    @Then("verifies the facebook project as the first result")
    public void verifiesTheFacebookProjectAsTheFirstResult() {
        landingPage.assertSearchResultTitle();
    }
    @After
    public void tearDown (){
        webDriver.quit();
    }
}