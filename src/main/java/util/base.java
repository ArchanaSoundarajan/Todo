package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class base {
    public static WebDriver driver;
    public Actions builder;
    public final Properties prop = new Properties();
    public WebDriverWait wait;
    public JavascriptExecutor executor;
    public base() throws IOException {
        setPropertyFile();
    }

    public void setPropertyFile() throws IOException{
        try {
        prop.load(new FileInputStream("src/main/java/Config/config.properities"));
            }
        catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

