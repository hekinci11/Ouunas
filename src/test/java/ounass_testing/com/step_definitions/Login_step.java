package ounass_testing.com.step_definitions;

import io.cucumber.java.en.Given;
import ounass_testing.com.pages.LoginPage;
import ounass_testing.com.utilities.ConfigurationReader;
import ounass_testing.com.utilities.Utilities;


public class Login_step {
    LoginPage lp = new LoginPage();

    @Given("As a user I could click Facebook button")
    public void as_a_user_I_could_click_Facebook_button() throws InterruptedException {
        Utilities.waitForVisibility(lp.facebookButton, 15);
        lp.facebookButton.click();
    }

    @Given("As a user I should login with valid credentials in Facebook")
    public void as_a_user_I_should_login_with_valid_credentials_in_Facebook() throws InterruptedException {
        lp.facebookUsername.sendKeys(ConfigurationReader.get("facebook_username"));
        lp.facebookPassword.sendKeys(ConfigurationReader.get("facebook_password"));
        lp.facebookLoginButton.click();
        Utilities.waitForVisibility(lp.Menu("men"), 15);

    }

}