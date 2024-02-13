package base;

import managers.DriverManager;
import managers.PageManager;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import project.properties.TestProperties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static managers.DriverManager.getInstance;

public class BaseTests {
    private static DriverManager driverManager = getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    private Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void before() {
        String baseUrl = properties.getProperty("HOSTNAME");
        driverManager.getDriver().get(baseUrl);
    }

    @AfterClass
    public static void after() throws IOException {
        File sourceFile = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("D:\\Download\\Обучение\\IBS\\Regard\\screenshot.png"));
        driverManager.getDriver().quit();
    }

}
