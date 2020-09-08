package StepDefinitions;

import Pages.HomePage;
import Pages.NossasMarcasPage;
import io.cucumber.java.en.*;

public class Steps_Chrome_Dasa {

    HomePage homePage = new HomePage();
    NossasMarcasPage nossasMarcasPage = new NossasMarcasPage();

    @Given("User opening the web browser")
    public void user_opening_the_web_browser() {
        homePage.openChromeBrowser();
    }

    @When("User access the URL {string}")
    public void user_access_the_url(String url) {
        homePage.acessingSiteDasa(url);
        homePage.takeScreenShot("HomePageDasa");
    }

    @Then("Page should have a image with alt '{string}")
    public void page_should_have_a_image_with_alt(String altTextLogo) {
        homePage.assertHomePageDasa(altTextLogo);
    }

    @Then("Click on link {string} on navbar")
    public void click_on_link_on_navbar(String textElement) {
        homePage.clickMainMenu_NossasMarcas(textElement);
    }

    @Then("Page should have a div with text {string}")
    public void page_should_have_a_div_with_text(String textElement) {
        homePage.assertNossasMarcasPage(textElement);
        homePage.takeScreenShot("NossasMarcasPage");
    }

    @When("Click on link with id {string} to search the labs")
    public void click_on_link_with_id_to_search_the_labs(String id) {
        nossasMarcasPage.rollNavBarUpToBotton();
        nossasMarcasPage.clickOnButtonToSearchLabs(id);
    }

    @When("Click in combo field with id {string}")
    public void click_in_combo_field_with_id(String id) {
        nossasMarcasPage.clickInFilterRegion(id);
    }

    @When("Select the option {string}")
    public void select_the_option(String option) {
        nossasMarcasPage.selectSaoPauloInRegionField(option);
    }

    @Then("the system should display all labs of São Paulo region.")
    public void the_system_should_display_all_labs_of_são_paulo_region() {
        nossasMarcasPage.assertLabsByRegion();
    }

    @When("Selecting the lab {string}")
    public void selecting_the_lab(String lab) {
        nossasMarcasPage.clickInLabDelboniImg(lab);
    }

    @Then("Page should have the  {string} title")
    public void page_should_have_the_title(String string) {

    }

    @Then("Page should have a link with a text {string}")
    public void page_should_have_a_link_with_a_text(String string) {

    }

    @When("Clicking on link with a text {string}")
    public void clicking_on_link_with_a_text(String string) {

    }

    @Then("User see the webpage of Delboni Auriemo lab.")
    public void user_see_the_webpage_of_delboni_auriemo_lab() {

    }

    @Then("close browser")
    public void close_browser() {

    }

}
