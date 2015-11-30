package axonactive.webapp.jbehaveSteps;
import axonactive.webapp.pages.LoginPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by nththuy on 10/30/15.
 */
public class Login  extends ScenarioSteps {

    LoginPage loginPage;

    @BeforeScenario
    public void beforeScenario() {
       loginPage.getDriver().manage().window().maximize();
       loginPage.getDriver().manage().deleteAllCookies();
    }

    @Given("I have already login Zing Poll successfully with email $email and password $password")
    public void login_successfully(String email, String password) throws InterruptedException{
        loginPage.open();
        loginPage.isWelcompage();
        loginPage.changeLanguage();
        loginPage.click_login_to_navigate_to_login_form();
        Assert.assertEquals(true, loginPage.isLoginForm());
        loginPage.type_email(email);
        loginPage.type_password(password);
        loginPage.submit_login();
    }

    @Given("I am on ZingPoll website")
    public void zingpoll_page() throws InterruptedException{
        loginPage.open();
        loginPage.isWelcompage();
    }

    @When("I change English language for website")
    public void change_language() throws InterruptedException{
       loginPage.changeLanguage();
    }

    @Then("I click the Sign In button on the menu bar to register an new account")
    public void click_sign_in() throws InterruptedException{
        loginPage.click_login_to_navigate_to_login_form();
    }

    @Then("The Sign In form should be shown")
    public void verify_sign_in_form() throws InterruptedException{
        Assert.assertEquals(true, loginPage.isLoginForm());
    }

    @When("I enter email $email and password $password")
    public void type_email_and_password(String email, String password) throws InterruptedException{
        loginPage.type_email(email);
        loginPage.type_password(password);
    }

    @When("I click the Sign In button on the form")
    public void submit_login_form() throws InterruptedException{
        loginPage.submit_login();


    }


    @Then("I verify the failure message $message")
    public void verify_the_failure_message(String message) throws InterruptedException{
        loginPage.verify_login_fail_cases(message);

    }
    @Then("I log in into website successful")
    public void verify_log_in_into_website_successful() throws InterruptedException{
        Assert.assertEquals(true,loginPage.verify_login_successfully());

    }

    @Given("a system state")
    public void a(){
        loginPage.open();

    }


}
