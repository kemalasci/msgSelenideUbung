package utils;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class MyMethods implements Locators {
    public String randomStringMail() {
        //  String rndString = UUID.randomUUID().toString();
        String rndString = RandomStringUtils.randomAlphabetic(8);

        return rndString + "@gmail.com";
    }
    public String randomUserName() {
        //  String rndString = UUID.randomUUID().toString();
        String rndString = RandomStringUtils.randomAlphabetic(8);

        return rndString ;
    }


    private static final String[] charCategories = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        System.out.println(new String(password));
        return new String(password);
    }
    public void verifyProduktPrice(By locator1, By locator2, By locator3, By locator4) {
        $(locator1).shouldBe(Condition.appear);


        String strRedProduktPrice = $(locator1).getText().replaceAll("[^\\d]", "");
        int redProduktPrice1 = Integer.parseInt(strRedProduktPrice);
        System.out.println("produktPriceRed= "+ redProduktPrice1);

        String strBlauProduktPrice2 = $(locator2).getText().replaceAll("[^\\d]", "");
        int blauProduktPrice2 = Integer.parseInt(strBlauProduktPrice2);
        System.out.println("produktPriceBlau= "+ blauProduktPrice2);


        String strShipping = $(locator3).getText().replaceAll("[^\\d]", "");
        int shipping = Integer.parseInt(strShipping);
        System.out.println("shipping= "+ shipping);

        int totalPrice=shipping+redProduktPrice1+blauProduktPrice2;
        System.out.println("totalPrice= " +totalPrice);

        String strtotalPriceCheck = $(locator4).getText().replaceAll("[^\\d]", "");
        int totalPriceCheck = Integer.parseInt(strtotalPriceCheck);

        Assert.assertEquals(totalPrice,totalPriceCheck);

    }

}
