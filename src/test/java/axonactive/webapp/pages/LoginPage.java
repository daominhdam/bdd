package axonactive.webapp.pages;

import axonactive.core.SystemPropertiesConfigurationOverwrite;
import axonactive.webapp.until.TestUtils;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nththuy on 10/30/15.
 */

@DefaultUrl("http://zingpoll.com")
public class LoginPage extends PageObject{

    @FindBy(id="Loginform")
    WebElementFacade loginForm;

    @FindBy(id="loginEmail")
    WebElementFacade loginEmail;

    @FindBy(id="loginPassword")
    WebElementFacade loginPasswordElement;

    @FindBy(id="button-login")
    WebElementFacade  buttonLogin;


    @FindBy(className="dropdown")
    WebElementFacade  dropdownMenu;//link access

    @FindBy(id="user-place")
    WebElementFacade  user_place;// menu

    //check the current page is welcome page
    public Boolean isWelcompage(){
        this.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (!user_place.isDisplayed()) {
            return false;
        }
        return true;

    }

    //check the current page is login form
    public Boolean isLoginForm(){
        this.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (!loginForm.isDisplayed()) {
            return false;
        }
        return true;

    }

    //click button to navigate to Login Form
    public void click_login_to_navigate_to_login_form(){
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginForm.click();
    }

    //type email into email input
    public void type_email(String email) throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("loginEmail")));
        loginEmail.type(email);
    }

    //type password into password input
    public void type_password(String loginPassword) throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("loginPassword")));
        loginPasswordElement.type(loginPassword);
    }

    //submit login button on login form
    public void submit_login(){
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonLogin.click();
    }


    // verify that info user appear after logging successfully
    public Boolean verify_login_successfully(){
        this.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        if(user_place.findElement(By.className("dropdown")) != null){
            return true;
        }
        return false;
    }


    // verify message in case of logging failure
    public void verify_login_fail_cases(String messagefailure) throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(true, this.checkMessageFailure(messagefailure));
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    public Boolean checkMessageFailure (String messageFail) throws InterruptedException{
        WebElement element = this.getDriver().findElement(By.id("loginForm"));
        List<WebElement> list = element.findElements(By.tagName("div"));
        int j =0;
        while(j<=1){
            List<WebElement> elementList = list.get(j).findElements(By.tagName("small"));
            if (elementList != null) {
                for (int i = 0; i <= elementList.size() - 1; i++) {
                    if(elementList.get(i).getText().contains(messageFail)){
                        return true;
                    }
                }
            }
            j++;
        }
        return false;
    }


    // click language dropdown , check english language
    public void changeLanguage() throws InterruptedException{
        List<WebElement> element = this.getDriver().findElements(By.id("user-place"));
        if(element != null && element.size() > 1){
            List<WebElement> webElementList = element.get(1).findElements(By.tagName("li"));
            webElementList.get(1).click();
            webElementList.get(2).click();//english language
            this.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }

}
