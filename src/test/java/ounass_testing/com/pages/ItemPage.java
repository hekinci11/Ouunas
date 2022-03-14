package ounass_testing.com.pages;

import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ounass_testing.com.utilities.Driver;
import ounass_testing.com.utilities.Utilities;

import java.util.concurrent.TimeUnit;

public class ItemPage extends BasePage{

    @FindBy(xpath = "(//*[@class='ContentPage']/div)[11]")
    public WebElement tshirt;


    @FindBy(xpath = "//*[@class='Select-control']")
    public WebElement selectSizeDropdown;

    @FindBy(xpath = "//*[@class='AddToBag']")
    public WebElement addToBagButton;

    public WebElement colour(String str){
        return Driver.get().findElement(By.xpath("//*[@class='ColorSelection']//button[@title='"+str+"']"));
    }

    public WebElement selectedTshirt(String str){
        return Driver.get().findElement(By.xpath("(//*[@class='Product-contents']/a[contains(@href,'"+str+"')])[1]"));
    }

    public void size(String str) throws InterruptedException {

        Driver.get().findElement(By.xpath("//div[@class='Select-placeholder']")).click();
        WebElement size = Driver.get().findElement(By.cssSelector(".Select-input"));
        Utilities.setAttribute(size,"aria-expanded","true");
        Utilities.setAttribute(size,"aria-activedescendant","react-select-2--option-2");
        Utilities.scrollToElement(addToBagButton);
        Utilities.waitForClickablility(size,15);
        size.click();

    }


}
