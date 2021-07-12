package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class mainPage extends base {
   // WebDriverWait wait = new WebDriverWait(driver,30);
    public static List<String> actualOutput = new ArrayList<>();
    public static List<String> expectedOutput = new ArrayList<>();
    public static List<String> lstTask = new ArrayList<>();
    @FindBy (xpath = "//input[@class='new-todo']")
    public static WebElement addTask;

    @FindBy(xpath = "//ul[@class='todo-list']/li")
    public static List<WebElement> listofTask;

    @FindBy(xpath = "//a[contains (text(), 'Active')]")
    public static WebElement activeTab;

    @FindBy(xpath = "//a[contains (text(), 'All')]")
    public static WebElement allTab;

    @FindBy(xpath = "//a[contains (text(), 'Completed')]")
    public static WebElement completedTab;
    public static WebElement eleCompleteTask;
    public static WebElement eleDelTask;
    @FindBy(xpath = "//button[@class='clear-completed']")
    public static WebElement btnClrCompletedTask;
    @FindBy(xpath = "//label[@for='toggle-all']")
    public static WebElement markAllCompleteTask;

    public mainPage() throws IOException {
    }


    public List<String> createTodoList() {
        lstTask = new ArrayList<String>(Arrays.asList(prop.getProperty("TASK_LIST").split(",")));
        for (int i = 0; i < lstTask.size(); i++) {
            boolean isPresent = addTask.isDisplayed();
            if (isPresent) {
                addTask.sendKeys(lstTask.get(i));
                builder.sendKeys(ENTER).build().perform();
            }
            }
            return lstTask;
    }
        protected List<String> getActlTaskList() {
        actualOutput.clear();
            if (listofTask != null) {
                for (WebElement element : listofTask) {
                    actualOutput.add(element.getText());
                }
            }
            return actualOutput;
            }

    protected void setEleCompleteTask  (String strTaskname) throws Exception {
        try {
             eleCompleteTask= driver.findElement(By.xpath("//label[contains (text(), '" +strTaskname+"')]/preceding-sibling::input[@class='toggle']"));
        } catch (AssertionError Ae) {
           Ae.printStackTrace();
        }
        return ;
   }
    protected void setEleDeleteTask  (String strTaskname) throws Exception {
        try {
            eleDelTask= driver.findElement(By.xpath("//label[contains (text(), '" +strTaskname+"')]/following-sibling::button[@class='destroy']"));
        } catch (AssertionError Ae) {
            Ae.printStackTrace();
        }
        return ;
    }

    }
