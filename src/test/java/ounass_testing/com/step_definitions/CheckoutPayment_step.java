package ounass_testing.com.step_definitions;

import io.cucumber.java.en.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ounass_testing.com.pages.CartPage;
import ounass_testing.com.pages.ItemPage;
import ounass_testing.com.utilities.ConfigurationReader;
import ounass_testing.com.utilities.Driver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutPayment_step {
        ItemPage ip = new ItemPage();
        CartPage cp = new CartPage();


    @Given("As a user I could select MEN menu")
    public void as_a_user_I_could_select_MEN_menu() {
        ip.Menu(ConfigurationReader.get("genderMenu")).click();

    }
    @Given("As a user I could select TSHIRTS")
    public void as_a_user_I_could_select_TSHIRTS() {
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,100)", "");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ip.tshirt.click();
    }

    @Given("As a user I could select {string}")
    public void as_a_user_I_could_select(String string) {
        ip.selectedTshirt("qasimi").click();
    }


    @Given("As a user I could select size and colour and add it to bag")
    public void as_a_user_I_could_select_size_and_colour_and_add_it_to_bag() throws IOException, InterruptedException {
        FileInputStream fileInputStream=new FileInputStream("on.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook((fileInputStream));
        XSSFSheet sheet=workbook.getSheet("Sheet1");

        int rowNum=sheet.getLastRowNum();

        Driver.waitFor(2);

        List<String> excelContent =new ArrayList<>();
        for (int i = 1; i <= rowNum; i++) {
            ip.selectSizeDropdown.click();
            Thread.sleep(2000);
            ip.size(sheet.getRow(i).getCell(0).toString());
            Thread.sleep(2000);
            ip.colour(sheet.getRow(i).getCell(1).toString()).click();
            ip.addToBagButton.click();
        }

        ip.Menu("cart").click();

    }

    @Given("Verify that all selected items are in the bag")
    public void verify_that_all_selected_items_are_in_the_bag() throws IOException {
        List<WebElement> itemSize = cp.infoInBag("Size");
        FileInputStream fileInputStream=new FileInputStream("on.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook((fileInputStream));
        XSSFSheet sheet=workbook.getSheet("Sheet1");

        for (int i = 0; i < itemSize.size(); i++) {
            assertEquals(itemSize.get(i).getText(),sheet.getRow(i).getCell(0).toString());

        }
        List<WebElement> itemColour = cp.infoInBag("Colour");
        for (int i = 0; i < itemColour.size(); i++) {
            assertEquals(itemColour.get(i).getText(),sheet.getRow(i).getCell(0).toString());

        }

    }

    @Given("As a user I could click secure check-out button")
    public void as_a_user_I_could_click_secure_check_out_button() {
        cp.checkOuTButton.click();
    }

    @Given("As a User I could fill the address information field")
    public void as_a_User_I_could_fill_the_address_information_field() throws IOException, InterruptedException {
        cp.enterAddress.click();

        FileInputStream fileInputStream=new FileInputStream("on.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook((fileInputStream));
        XSSFSheet sheet=workbook.getSheet("Sheet2");

        for (int i = 0; i < 4; i++) {

            WebElement wb = cp.addressFields(sheet.getRow(0).getCell(i).toString());
            wb.sendKeys(sheet.getRow(1).getCell(i).toString());
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        cp.continueButton.click();

    }

    @Then("Verify that payment page is launched succesfully")
    public void verify_that_payment_page_is_launched_succesfully() {
        assertTrue(Driver.get().getCurrentUrl().contains("payment"));
    }

}
