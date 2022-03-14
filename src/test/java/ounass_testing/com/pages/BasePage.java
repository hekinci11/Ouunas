package ounass_testing.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ounass_testing.com.utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@class='Popup-button']")
    public WebElement LoginAccount;


    public WebElement Menu(String str) {
        return Driver.get().findElement(By.xpath("//a[@href='/" + str + "']"));
    }

}
