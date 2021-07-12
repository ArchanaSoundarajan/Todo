package stepDefinitions;
import Pages.mainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class addTodo extends mainPage {

    @Before
    public void setUp () {
        try {
            driver = new ChromeDriver();
            builder = new Actions(driver);
            System.setProperty(prop.getProperty("BROWSER"), prop.getProperty("BROWSER_LIB_PATH"));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, 30);
            executor = (JavascriptExecutor) driver;
            expectedOutput.clear();
            //driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
        }
        catch (Exception e){
            System.out.println("Exception is"+e);
        }
    }


    public addTodo() throws IOException {
    }
        @Given("Open todo mvc url")
        public void openTodoMvcUrl () {
        driver.get(prop.getProperty("URL"));
    }

        @Then("User Verify mvn url loaded Successfully")
        public void userVerifyMvnUrlLoadedSuccessfully () {
        String pageTitle = driver.getTitle();
        System.out.println(prop.getProperty("PAGE_TITLE"));
        Assert.assertTrue(pageTitle.contains(prop.getProperty("PAGE_TITLE")));
    }

        @When("User Add todo {string},{string} and {string}")
        public void useraddtodoand(String Task1, String Task2, String Task3){
        // Write code here that turns the phrase above into concrete actions
        createTodoList();
    }

        @Then("User Verify Todo list created and added to todo list successfully")
        public void userverifytodolistcreatedandaddedtotodolistsuccessfully () {
        // Write code here that turns the phrase above into concrete actions
        getActlTaskList();
        Assert.assertEquals(lstTask, actualOutput);
    }

        @When("User Complete the task {string}")
        public void userCompleteTheTask (String Task1) throws Exception {
            setEleCompleteTask("Task1");
            expectedOutput.add("Task1");
            lstTask.remove("Task1");
            builder.moveToElement(eleCompleteTask).click().perform();
    }

        @And("User Click on Complete Button")
        public void userClickOnCompleteButton () {
        builder.moveToElement(completedTab).click().perform();
    }

        @Then("User Should see {string}")
        public void userShouldSee (String Task1){
        getActlTaskList();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

        @And("User Click on Active Button")
        public void userClickOnActiveButton () {
        wait.until(ExpectedConditions.elementToBeClickable(activeTab));
        activeTab.click();
       // builder.moveToElement(activeTab).click().perform();
    }

    @Then("User Should not see {string}")
    public void userShouldNotSee(String Task1) {
        getActlTaskList();
        Assert.assertEquals(lstTask, actualOutput);
    }

    @Then("User Should see only {string}")
    public void userShouldSeeOnly(String Task3) {
        getActlTaskList();
        Assert.assertEquals(lstTask, actualOutput);
    }
        @When("User Complete the task {string} and {string}")
        public void userCompleteTheTaskAnd (String Task1, String Task2) throws Exception {
            setEleCompleteTask("Task1");
        builder.moveToElement(eleCompleteTask).click().perform();
        lstTask.remove("Task1");
            setEleCompleteTask("Task2");
        builder.moveToElement(eleCompleteTask).click().perform();
            lstTask.remove("Task2");
    }

        @And("User Click on Clear Completed Button")
        public void userClickOnClearCompletedButton () {
        builder.moveToElement(btnClrCompletedTask).click().perform();
    }

        @When("User delete the task {string}")
        public void userDeleteTheTask (String Task1) throws Exception {
            setEleDeleteTask("Task1");
            wait.until(ExpectedConditions.elementToBeClickable(eleDelTask));
            executor.executeScript("arguments[0].click();", eleDelTask);
            //builder.moveToElement(eleDelTask).click().perform();
        lstTask.remove("Task1");
    }
    @Then("User Should see {string} and {string}")
    public void userShouldSeeAnd(String Task2, String Task3) {
        getActlTaskList();
        Assert.assertEquals(lstTask,actualOutput);
    }
        @When("User Mark all task complete")
        public void userMarkAllTaskComplete () {
        builder.moveToElement(markAllCompleteTask).click().perform();
    }

        @Then("User Verify all todo list items are complete successfully")
        public void userVerifyAllTodoListItemsAreCompleteSuccessfully () {
        getActlTaskList();
        Assert.assertEquals(0, actualOutput.size());

    }
    @After
    public void teardown(){
        driver.quit();
    }

}
