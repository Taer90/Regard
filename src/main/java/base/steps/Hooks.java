package base.steps;

import io.cucumber.java.After;
import managers.DriverManager;
import managers.PageManager;
import io.cucumber.java.Before;

import static managers.DriverManager.getInstance;


public class Hooks {

    private static DriverManager driverManager = getInstance();
    protected PageManager pageManager = PageManager.getInstance();

    @Before
    public void before() {

        String baseUrl = ("http://regard.ru/");
        driverManager.getDriver().get(baseUrl);
    }

    @After
    public static void after() {
        driverManager.quitDriver();
        PageManager.getInstance().quitPages();
    }
}

