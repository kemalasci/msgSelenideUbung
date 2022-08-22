package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.webdriver.FirefoxDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.Locators;
import utils.MyMethods;


import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static utils.InformationClass.*;

public class _2_LoginStepdefs extends MyMethods implements Locators {


    @Given("user on homePage")
    public void userOnHomePage() {

        open(url);
        System.setProperty("selenide.browser", "Edge");

    }




    @When("user login as follows")
    public void userLoginAsFollows(DataTable table) {
        $(menuUserItem).click();

        Map<String, String> map = table.asMap(String.class, String.class);

        $(inputUserName).shouldBe(Condition.appear ).sendKeys( map.get("userName"));
        $(inputPassword).shouldBe(Condition.appear).sendKeys(map.get("password"));

        $(signIn).click();
    }


    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {

        $(userNameTitle).shouldBe(Condition.text(inputUserNameString));
    }

}

