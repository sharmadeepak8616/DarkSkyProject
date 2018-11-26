package util;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class DoVerification {

    public static SoftAssert assertion = new SoftAssert();

    public static boolean isTwoStringsEquals(String expectedMsg, String actualMsg) {
        boolean result = expectedMsg.equals(actualMsg);
        //assertion.assertTrue(result, "Message is not as expected - " + actualMsg);
        Assert.assertTrue(result, "Given values are equal - Actual :" + actualMsg + " - Expected :" + expectedMsg);
        return result;
    }

    public static boolean isTwoStringsEqualsIgnorecase(String expectedMsg, String actualMsg) {
        boolean result = expectedMsg.equalsIgnoreCase(actualMsg);
        //assertion.assertTrue(result, "Message is not as expected - " + actualMsg);
        Assert.assertTrue(result, "Given values are equal(with ignore case) - Actual :" + actualMsg + " - Expected :" + expectedMsg);
        return result;
    }

    public static boolean isTwoArrayListEquals(ArrayList expectedArrayList, ArrayList actualArrayList) {
        boolean result = false;
        int expectedArrayLength = expectedArrayList.size();
        int actualArrayLength = actualArrayList.size();

        if (expectedArrayLength == actualArrayLength) {
            for (int i = 0 ; i < actualArrayList.size() ; i++) {
                Assert.assertTrue(actualArrayList.get(i).equals(expectedArrayList.get(i)) , "Value is not same. Actual: " + actualArrayList.get(i) + ", and expected: " + expectedArrayList.get(i));
                result = true;
            }
        } else {
            Assert.assertFalse(result, "Length of given arrayList didn't match");
            result = false;
        }
        return result;
    }



}
