package axonactive.webapp.pages;

import axonactive.webapp.until.TestUtils;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by nththuy on 10/30/15.
 */

public class CreatePollPage extends PageObject {


    @FindBy(name="question_content")
    WebElementFacade question_content;


    @FindBy(id="single-answer")
    WebElementFacade single_answer;

    @FindBy(id="multi-answer")
    WebElementFacade mul_answer;

    @FindBy(id="inputtext1")
    WebElementFacade inputtext1;

    @FindBy(id="inputtext2")
    WebElementFacade inputtext2;

    @FindBy(id="guestEmail")
    WebElementFacade guestEmail;

    @FindBy(id="btAsknow")
    WebElementFacade btAsknow;

    @FindBy(id="partipantLink2")
    WebElementFacade  partipantLink2;//link access


    //type question into question textbox
    public void type_question(String question) throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.name("question_content")));
        question_content.type(question);
    }

    //click single choice for answer
    public void click_single_choice() throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("single-answer")));
        single_answer.click();
    }

    //click multi choices for answer
    public void click_mul_choice() throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("multi-answer")));
        mul_answer.click();
    }

    //type answer 1 into first textbox
    public void type_answer_1(String answer) throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("inputtext1")));
        inputtext1.type(answer);
    }

    //type answer 2 into first textbox
    public void type_answer_2(String answer) throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("inputtext2")));
        inputtext2.type(answer);
    }

    //type guest email
    public void type_email(String email)  throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("guestEmail")));
        guestEmail.type(email);
    }

    //click submit to create a zingpoll
    public void submit_create_zingpoll() throws InterruptedException{
        this.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestUtils.fnHighlightMe(this.getDriver(), this.getDriver().findElement(By.id("btAsknow")));
        btAsknow.click();
    }


    //check sharing link after creating poll successfully
    public Boolean isDisplayedLink(){
        this.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (!partipantLink2.isDisplayed()) {
            return false;
        }
        return true;

    }



}
