package runners;

import com.codeborne.selenide.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterSuite;


@CucumberOptions(
        tags = "@smoke",
        features = {"src/test/java/features"},
        glue = {"stepdefs"},
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)

public class Runner1 extends AbstractTestNGCucumberTests {





}
