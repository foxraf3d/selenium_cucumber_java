package Utilities;

import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.*;


public class TestUtilities {

    private static String screenShots = "ScreenShots/Img";
    private static File screenShotPath = new File(screenShots);

    public void getScreenShot(int browser, String descriptionScreen){
        try {
            TakesScreenshot scrShot = ((TakesScreenshot)DriverFactory.getDriver(browser));
            File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
            File dstFile = new File(screenShotPath.getAbsoluteFile()+descriptionScreen+".png");
            FileUtils.copyFile(scrFile, dstFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rollNavBarUpToBotton(By by, int browser){
        WebElement element = DriverFactory.getDriver(browser).findElement(by);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver(browser);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void selectOptionOnComboBox(String comboID, int browser, String option){
        waitLoad(1000);
        DriverFactory.getDriver(browser).findElement(By.xpath(
                "//select[@id = '" +comboID+ "']/option[contains(.,'"+option+ "')]"))
                .click();
    }

    public void waitLoad(long time){
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> labsOfRegionSP() {
        List<String> labsOfSP = new ArrayList<String>();
        labsOfSP.add("Alta Diagnósticos");
        labsOfSP.add("Delboni Auriemo");
        labsOfSP.add("Labsim");
        labsOfSP.add("Cytolab");
        labsOfSP.add("Laboratório Médico Vital Brasil");
        labsOfSP.add("Salomão Zoppi Diagnósticos");
        labsOfSP.add("Laboratório Oswaldo Cruz");
        labsOfSP.add("Lavoisier Laboratório e Imagem");
        labsOfSP.add("Deliberato Análises Clínicas");
        labsOfSP.add("Previlab");
        labsOfSP.add("ValeClin");
        labsOfSP.add("Padrão Ribeirão");
        return labsOfSP;
    }

    public void killBrowser(int browser){
        DriverFactory.getDriver(browser).quit();
    }
}
