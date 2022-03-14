package ounass_testing.com.step_definitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;
import ounass_testing.com.pages.RegisterAccount_page;
import ounass_testing.com.utilities.ConfigurationReader;
import ounass_testing.com.utilities.Driver;
import ounass_testing.com.utilities.Utilities;


import static org.junit.Assert.*;

public class RegisterAccount_step {
    RegisterAccount_page rp = new RegisterAccount_page();

    @Given("As a user I  succesfully launch the website")
    public void as_a_user_I_succesfully_launch_the_website() {
        Driver.get().get(ConfigurationReader.get("url"));


    }

    @Given("As a user I should click account button")
    public void as_a_user_I_should_click_account_button() {
        Actions ac = new Actions(Driver.get());
        ac.moveToElement(rp.LoginAccount);
        rp.LoginAccount.click();


    }

    @Given("As a user I should login with valid credentials")
    public void as_a_user_I_should_login_with_valid_credentials() throws InterruptedException {

        rp.emailBox.sendKeys(ConfigurationReader.get("validUsername"));
        rp.passwordBox.sendKeys(ConfigurationReader.get("validPassword"));
        rp.loginButton.click();
        Utilities.waitForVisibility(rp.Menu("customer"), 15);

    }

    @Given("Verify that homepage is displayed")
    public void verify_that_homepage_is_displayed() throws InterruptedException {

       Thread.sleep(3000);
        assertEquals("You are not on home page", Driver.get().getTitle(), "Shop Luxury for Online | Ounass UAE");
    }

    @Given("As a user I should hover over to Account menu and click it")
    public void as_a_user_I_should_hover_over_to_Account_menu_and_click_it() {
        rp.Menu("customer").click();

    }

    @Given("Verify that customer page is displayed")
    public void verify_that_customer_page_is_displayed() {
        assertEquals("You are not on the customer page", Driver.get().getCurrentUrl(), "https://www.ounass.ae/customer");

    }

    @Given("As a user I could click edit button")
    public void as_a_user_I_could_click_edit_button() {
        rp.editButton.click();

    }

    @Then("EmailBox should not be clickable")
    public void emailbox_should_not_be_clickable() {
        assertFalse("email box is not disabled", rp.emailBoxDisabled());

    }

    @Then("Verfy that Not Editable message is displayed")
    public void verfy_that_Not_Editable_message_is_displayed() {

        assertTrue(rp.containsMessageinEmail());

    }


    @Given("Verify that the valid email address and the address shown must match.")
    public void verify_that_the_valid_email_address_and_the_address_shown_must_match() {

        assertEquals("Emails are not same", rp.getAnEmail(), ConfigurationReader.get("email"));

    }


}
