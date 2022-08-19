package stepdefs;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.Locators;
import utils.MyMethods;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.InformationClass.*;

public class _1_UserRegistrationStepdefs extends MyMethods implements Locators {
    public static String randomRegisterStr = "";

    @When("navigate to Registration page")
    public void navigateToRegistrationPage() throws InterruptedException {

        $(menuUserItem).click();
        Thread.sleep(2000);
        $(createNewAccount).click();
    }

    @Then("Create a new account")
    public void createANewAccount(DataTable table) throws InterruptedException {
        Map<String, String> map = table.asMap(String.class, String.class);
        $(registUserNameInput).shouldBe(Condition.appear).sendKeys(randomRegisterStr = randomUserName());
        $(registEmailInput).shouldBe(Condition.appear).sendKeys(map.get("email"));
        $(registPasswordInput).shouldBe(Condition.appear).sendKeys(map.get("password"));
        $(registPasswordInputConfirm).shouldBe(Condition.appear).sendKeys(map.get("confirmPassword"));
        $(registNameInput).shouldBe(Condition.appear).sendKeys(map.get("firstName"));
        $(surNameInput).shouldBe(Condition.appear).sendKeys(map.get("lastName"));
        $(registPhoneNummerInput).shouldBe(Condition.appear).sendKeys(map.get("phoneNummer"));


        $(selectCountry).click();
        Thread.sleep(1000);
        $(selectCountry).shouldBe(Condition.appear).selectOptionByValue(selectCountryString);
        $(cityInput).shouldBe(Condition.appear).sendKeys(map.get("city"));
        $(addresInput).shouldBe(Condition.appear).sendKeys(map.get("addres"));
        $(stateInput).shouldBe(Condition.appear).sendKeys(map.get("state"));
        $(postCodeInput).shouldBe(Condition.appear).sendKeys(map.get("postCode"));
    }

    @And("tick  to Confim box and click to registiration")
    public void tickToConfimBoxAndClickToRegistiration() {
        $(agreeBox).shouldBe(Condition.appear).click();
        $(registerButton).shouldBe(Condition.appear).click();

    }

    @Then("Registration Success message should be displayed")
    public void registrationSuccessMessageShouldBeDisplayed() {
        $(userNameTitle).shouldBe(Condition.appear);
        $(userNameTitle).shouldBe(Condition.text(randomRegisterStr));

    }
}
