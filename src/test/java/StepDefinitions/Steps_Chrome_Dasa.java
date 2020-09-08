package StepDefinitions;

import Pages.Chrome_HomePage;
import Pages.Chrome_NossasMarcasPage;
import io.cucumber.java.en.*;

public class Steps_Chrome_Dasa {

    Chrome_HomePage chromeHomePage = new Chrome_HomePage();
    Chrome_NossasMarcasPage chromeNossasMarcasPage = new Chrome_NossasMarcasPage();

    @Given("User opening the web browser")
    public void user_opening_the_web_browser() {
        chromeHomePage.openChromeBrowser();
    }

    @When("User access the URL {string}")
    public void user_access_the_url(String url) {
        chromeHomePage.acessingSiteDasa(url);
        chromeHomePage.takeScreenShot("HomePageDasa");
    }

    @Then("Page should have a image with alt '{string}")
    public void page_should_have_a_image_with_alt(String altTextLogo) {
        chromeHomePage.assertHomePageDasa(altTextLogo);
    }

    @Then("Click on link {string} on navbar")
    public void click_on_link_on_navbar(String textElement) {
        chromeHomePage.clickMainMenu_NossasMarcas(textElement);
    }

    @Then("Page should have a div with text {string}")
    public void page_should_have_a_div_with_text(String textElement) {
        chromeHomePage.assertNossasMarcasPage(textElement);
        chromeHomePage.takeScreenShot("NossasMarcasPage");
    }

    @When("Click on link with id {string} to search the labs")
    public void click_on_link_with_id_to_search_the_labs(String id) {
        chromeNossasMarcasPage.rollNavBarUpToBotton();
        chromeNossasMarcasPage.clickOnButtonToSearchLabs(id);
    }

    @When("Click in combo field with id {string}")
    public void click_in_combo_field_with_id(String id) {
        chromeNossasMarcasPage.clickInFilterRegion(id);
    }

    @When("Select the option {string}")
    public void select_the_option(String option) {
        chromeNossasMarcasPage.selectSaoPauloInRegionField(option);
    }

    @Then("the system should display all labs of São Paulo region.")
    public void the_system_should_display_all_labs_of_são_paulo_region() {
        chromeNossasMarcasPage.assertLabsByRegion();
    }

    @When("Selecting the lab {string}")
    public void selecting_the_lab(String lab) {
        chromeNossasMarcasPage.clickInLabDelboniImg(lab);
    }

    @Then("Page should have the  {string} title")
    public void page_should_have_the_title(String textTitle) {
        chromeNossasMarcasPage.assertLabPageOfDelboni(textTitle);
    }

    @Then("Page should have a link with a text {string}")
    public void page_should_have_a_link_with_a_text(String linkText) {
        chromeNossasMarcasPage.assertLinkOnDelboniAuriemoPage(linkText);
    }

    @When("Clicking on link with a text {string}")
    public void clicking_on_link_with_a_text(String linkText) {
        chromeNossasMarcasPage.clickInLinkOfLab(linkText);
    }

    @Then("User see the webpage of Delboni Auriemo lab.")
    public void user_see_the_webpage_of_delboni_auriemo_lab() {
        chromeNossasMarcasPage.assertRedirectionForTheOfficialLabPage();
    }

    @Then("close browser")
    public void close_browser() {
        //Browser close in @AfterClass method on TestRunner -> TestRun
    }

}
