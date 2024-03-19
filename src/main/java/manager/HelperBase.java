package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By locator){
        System.out.println(locator);
        return driver.findElement(locator);
    }

   private List<WebElement>findElementsBase(By locator){
        return driver.findElements(locator);
    }

    public void clickBase(By locator){
        findElementBase(locator).click();
    }

    public void typeBase(By locator, String text){
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause(int sec){
        try {
            Thread.sleep(1000L *sec );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isElementPresent(By locator){
        return !findElementsBase(locator).isEmpty();
    }

    public boolean isTextInElementEquals(By locator, String text){
        return findElementBase(locator).getText().equals(text);
    }
}
