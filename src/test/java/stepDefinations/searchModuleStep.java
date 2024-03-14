package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import setup.Setup;

public class searchModuleStep extends Setup {
    SearchPage searchPage=new SearchPage(webDriver);

    @Given("User is a guest \\(not logged in) on GitHub's landing page")
    public void user_is_a_guest_not_logged_in_on_git_hub_s_landing_page() {
        webDriver.get("https://github.com/");
    }
    @When("The user clicks the About button in the landing page footer")
    public void the_user_clicks_the_about_button_in_the_landing_page_footer() throws InterruptedException {
        searchPage.scroll(webDriver);
        Thread.sleep(3000);
        searchPage.clickAbout();

    }

    @Then("Confirm that the content on the page provides information about GitHub's purpose, mission, and related details")
    public void confirm_that_the_content_on_the_page_provides_information_about_git_hub_s_purpose_mission_and_related_details() throws InterruptedException {
        Thread.sleep(3000);
        searchPage.aboutTitle();
    }
    @After
    public void tearDown (){
        webDriver.quit();
    }
}
