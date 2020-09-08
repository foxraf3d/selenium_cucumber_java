package Pages;

import Core.DriverFactory;
import Utilities.TestUtilities;
import org.openqa.selenium.By;

import static Utilities.BrowserDefinition.CHROME;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class HomePage extends DriverFactory {

    TestUtilities utils = new TestUtilities();

    public  void openChromeBrowser(){
        getDriver(CHROME);
    }

    public void acessingSiteDasa(String url){
        getDriver(CHROME).navigate().to(url);
    }

    public void assertHomePageDasa(String altTextLogo){
        try {
            Boolean elementExists = getDriver(CHROME)
                    .findElement(By.xpath("//div[@class='navbar-holder']//img[@alt='"+altTextLogo+"']"))
                    .isDisplayed();
            assertTrue(elementExists);
        }catch (Exception e){
            fail("element not found " + e.getMessage() );
        }

    }

    public void clickMainMenu_NossasMarcas(String textElement){
        getDriver(CHROME).findElement(By.linkText(textElement)).click();
    }

    public void takeScreenShot(String descripton){
        utils.getScreenShot(CHROME, descripton);
    }

    public void assertNossasMarcasPage(String textElement){
        try {
            boolean elementExists = getDriver(CHROME)
                    .findElement(By.xpath("//div[.='"+textElement+"']"))
                    .isDisplayed();
            assertTrue(elementExists);
        }catch (Exception e){
            fail("element not found " + e.getMessage());
        }
    }

}
