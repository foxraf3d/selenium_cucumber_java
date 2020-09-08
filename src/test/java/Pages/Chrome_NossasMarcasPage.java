package Pages;

import Core.DriverFactory;
import Utilities.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Utilities.BrowserDefinition.CHROME;
import static org.junit.Assert.*;

public class Chrome_NossasMarcasPage extends DriverFactory {

    TestUtilities utils = new TestUtilities();

    public void clickOnButtonToSearchLabs(String id){
        getDriver(CHROME).findElement(By.id(id)).click();
    }

    public void clickInFilterRegion(String id){}

    public void clickInLabDelboniImg(String lab){
        getDriver(CHROME).findElement(By.xpath("//img[@alt='"+lab+"']")).click();
    }

    public void clickInLinkOfLab(String linkText){
        getDriver(CHROME).findElement(By.linkText(linkText)).click();
    }

    public void assertLabPageOfDelboni(String textTitle){
        assertTrue(getDriver(CHROME).findElement(By.xpath("//h2[.='"+textTitle+"']")).isDisplayed());
        utils.getScreenShot(CHROME, "DescriptionDelboniAuriemo");
    }

    public void assertLinkOnDelboniAuriemoPage(String linkText){
        assertTrue(getDriver(CHROME).findElement(By.linkText(linkText)).isDisplayed());
    }

    public void assertRedirectionForTheOfficialLabPage(){
        utils.waitLoad(2000);

        ArrayList<String> tabs = new ArrayList<String>(getDriver(CHROME).getWindowHandles());
        getDriver(CHROME).switchTo().window(tabs.get(1));

        assertEquals("Delboni Auriemo | Laboratório de Exames e de Imagem", getDriver(CHROME).getTitle());
        assertEquals("https://delboniauriemo.com.br/", getDriver(CHROME).getCurrentUrl());
        utils.getScreenShot(CHROME, "SiteDelboniAuriemo");
    }

    public void selectSaoPauloInRegionField(String option){
        utils.selectOptionOnComboBox("region", CHROME, option);
        utils.rollNavBarUpToBotton(By.xpath("//h2[.='São Paulo']"), CHROME);
    }

    public void assertLabsByRegion(){
        List<String> listLabs = printAllLabsByRegion();
        List<String> expectedList = utils.labsOfRegionSP();
        utils.getScreenShot(CHROME, "LabsOfSaoPaulo");
        assertArrayEquals(listLabs.toArray(), expectedList.toArray());
    }

    public void rollNavBarUpToBotton(){
        utils.rollNavBarUpToBotton(By.className("subtitle"), CHROME);
    }

    private List<String> printAllLabsByRegion(){
        List<WebElement> texts = getDriver(CHROME).findElement(By.xpath("//*[@id='block-28']/div[2]")).findElements(By.tagName("img"));
        List<String> listLabs = new ArrayList<String>();
        int count = 0;
        utils.waitLoad(1000);
        for (WebElement text: texts) {
            System.out.println(text.getAttribute("alt"));
            listLabs.add(count, text.getAttribute("alt"));
            count++;
        }
        return listLabs;
    }

}
