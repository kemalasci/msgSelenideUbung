package stepdefs;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import utils.Locators;
import utils.MyMethods;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static utils.InformationClass.*;

public class _3_KaufenStepdefs extends MyMethods implements Locators {
    @Given("navigate to HP PAVILION 15Z TOUCH LAPTOP")
    public void navigateToHPPAVILIONZTOUCHLAPTOP() {
        $(seeOfferButton).shouldBe(Condition.enabled).click();
    }

    @Then("one blue 3 red Laptop add to cart")
    public void oneBlueRedLaptopAddToCart() throws InterruptedException {
        $(shopincardItem).shouldBe(Condition.appear).hover();


        if ($(shopincardItemRemove).isDisplayed()) {
            $(shopincardItemRemove).shouldBe(Condition.enabled).click();
        }


        Thread.sleep(1000);
        $(addToCardButton).shouldBe(Condition.enabled).click();
        Thread.sleep(1000);
        $(redProdukt).shouldBe(Condition.enabled).click();

        for (int i = 0; i < 3; i++) {
            $(plusButton).shouldBe(Condition.visible).click();
        }
        Thread.sleep(1000);
        $(addToCardButton).shouldBe(Condition.visible).click();
    }

    @And("The user should be able to purchase the products")
    public void theUserShouldBeAbleToPurchaseTheProducts() {
        $(shoppingCartItem).shouldBe(Condition.appear).click();
        $(checkOutButton).shouldBe(Condition.appear).click();

    }


    @Then("total product price and amount paid must be verified")
    public void totalProductPriceAndAmountPaidMustBeVerified() {
        verifyProduktPrice(redProduktPrice1, blauProduktPrice2, shippingPrice, totalPrice);
    }


    @And("Fill in payment method and purchase is complete")
    public void fillInPaymentMethodAndPurchaseIsComplete() throws InterruptedException, AWTException {
        $(nextButton).shouldBe(Condition.appear).click();
        $(safepayInput).shouldBe(Condition.appear).click();

        $(safepayInput).shouldBe(Condition.appear).clear();
        $(safepayInput).shouldBe(Condition.enabled).sendKeys(safePayUserName);
        $(safepayPasswortInput).shouldBe(Condition.appear).click();

        $(safepayPasswortInput).shouldBe(Condition.appear).clear();
        $(safepayPasswortInput).shouldBe(Condition.enabled).sendKeys(safePayPassword);
        $(buttonPayNow).shouldBe(Condition.appear).click();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        $(successMsjContainer).shouldBe(Condition.text(successMessage));

    }
}
