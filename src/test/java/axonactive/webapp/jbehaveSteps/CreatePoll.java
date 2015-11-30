package axonactive.webapp.jbehaveSteps;

import axonactive.webapp.pages.CreatePollPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by nththuy on 10/30/15.
 */
public class CreatePoll extends ScenarioSteps {

CreatePollPage createPollPage;


    @Given("I login ZingPoll website successful")
    public void zingpoll_page() throws InterruptedException{

    }

    @When("I enter $question into the question field")
    public void enter_question(String question) throws InterruptedException{
        createPollPage.type_question(question);
    }

    @When("I enter the $first_anwser and $second_answer into the answer fields")
    public void type_anwsers(String first_anwser,String second_answer ) throws InterruptedException{
        createPollPage.type_answer_1(first_anwser);
        createPollPage.type_answer_2(second_answer);
    }

    @When("I click the Create Poll button")
    public void submit_create_poll() throws InterruptedException{
        createPollPage.submit_create_zingpoll();
    }

    @Then("The poll is created successfully")
    public void verify_create_poll_successfully() throws InterruptedException {
        Assert.assertEquals(true, createPollPage.isDisplayedLink());

    }




}
