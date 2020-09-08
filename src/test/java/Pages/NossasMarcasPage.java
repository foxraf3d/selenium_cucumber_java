package Pages;

import Core.DriverFactory;
import Utilities.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Utilities.BrowserDefinition.CHROME;
import static org.junit.Assert.assertArrayEquals;

public class NossasMarcasPage extends DriverFactory {

    TestUtilities utils = new TestUtilities();

    public void clickOnButtonToSearchLabs(String id){
        getDriver(CHROME).findElement(By.id(id)).click();
    }

    public void clickInFilterRegion(String id){}

    public void clickInLabDelboniImg(String lab){
        getDriver(CHROME).findElement(By.xpath("//img[@alt='"+lab+"']")).click();
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
