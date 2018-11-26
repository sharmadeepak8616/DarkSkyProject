package framework.web_pages.DarkSky;

import framework.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import util.DateUtils;
import util.DoVerification;
import util.GetValuesUsingRegex;

import java.util.ArrayList;

public class HomePage  extends BasePage {

    private By textInputField = By.xpath("//form[@id='searchForm']//input");
    private By searchButton = By.xpath("//a[@class='searchButton']");
    private By presentTemperature = By.xpath("//span[@class='currently']//span[@class='summary swap']");
    private By temperatureLow = By.xpath("//span[@class='summary-high-low']/span[2]");
    private By temperatureHigh = By.xpath("//span[@class='summary-high-low']/span[3]");
    private By todaysTimeline = By.xpath("//a[@class='day'][@data-day='0']//span[@class='toggle']");
    private By todaysTimeLineMinTemp = By.xpath("//a[@class='day revealed'][@data-day='0']//span[@class='minTemp']");
    private By todaysTimeLineMaxTemp = By.xpath("//a[@class='day revealed'][@data-day='0']//span[@class='maxTemp']");
    private By lowTempFromTodaysDetail = By.xpath("//div[@class='dayDetails revealed']//div[@class='dayExtras']//span[@class='highTemp swip']//span[@class='temp']");
    private By highTempFromTodaysDetail = By.xpath("//div[@class='dayDetails revealed']//div[@class='dayExtras']//span[@class='lowTemp swap']//span[@class='temp']");


    private String tempBarValuesStart = "//div[@class='hours']//span[";
    private String tempBarValuesEnd = "]/span";
    public static int incrementTempBy;
    public static int forFutureHours;

    public void enterLocation(int enterLocation) {
        String location = Integer.toString(enterLocation);
        clearText(textInputField);
        sendText(textInputField, location);
    }

    public void clickOnSearchButton() {
        clickOn(searchButton);
    }

    private int getPresentTemperature() {
        return GetValuesUsingRegex.getCurrentTempValueUsingRegEx(getTextFromElement(presentTemperature));
    }

    private int getLowTemperature() {
        return GetValuesUsingRegex.getLowHighTempValueUsingRegEx(getTextFromElement(temperatureLow));
    }

    private int getHighTemperature() {
        return GetValuesUsingRegex.getLowHighTempValueUsingRegEx(getTextFromElement(temperatureHigh));
    }
/*
    private int getLowHighTempValue(String line) {
        String temp = line.split(":")[1];
        temp = temp.split("˚")[0];
        return Integer.parseInt(temp.trim());
    }
*/

    public void verifyPresentTempBetweenLowHigh() {
        try {
            Thread.sleep(5000);
            int present = getPresentTemperature();
            int low = getLowTemperature();
            int high = getHighTemperature();
            Assert.assertTrue(low <= present && present <= high, "Present temp (" + present + "˚) is not in between low (" + low + "˚) and high (" + high + "˚)");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyTemperatureBarValues(int incrementBy, int futureHours) {
        incrementTempBy = incrementBy;
        forFutureHours = futureHours;
        DoVerification.isTwoArrayListEquals(getExpectedTemperatureTimeline(), getActualTemperatureTimeline());
    }

    private ArrayList<String> getActualTemperatureTimeline() {
        ArrayList<String> actualTemperatureBar = new ArrayList<String>();
        for (int i = 1; i <= 23 ; i+=2) {
            String completeLocator = tempBarValuesStart + i + tempBarValuesEnd;
            actualTemperatureBar.add(getTextFromElement(By.xpath(completeLocator)));
        }
        return actualTemperatureBar;
    }

    private ArrayList<String> getExpectedTemperatureTimeline() {
        ArrayList<String> expectedTemperatureBar = new ArrayList<String>();
        String[] hour_DayHalf = DateUtils.getCurrentHourIn12Hours_hhaaFormat();
        String hour = hour_DayHalf[0];
        int hourInt = Integer.valueOf(hour);
        String dayTime = hour_DayHalf[1].toLowerCase();
        String tempValue = Integer.toString(hourInt) + dayTime;
        expectedTemperatureBar.add(tempValue);
        for (int i= 0 ; i < forFutureHours ; i++) {
            int prevValue = Integer.valueOf(GetValuesUsingRegex.getHourUsingRegex(expectedTemperatureBar.get(i)));
            int addThis = prevValue + incrementTempBy;
            if (prevValue == 12) {
                addThis = addThis - 12;
            } else if (addThis >= 12) {
                dayTime = DateUtils.switchDayHalf(dayTime);
                if(addThis != 12) {
                    addThis = addThis - 12;
                }
            }
            hour = Integer.toString(addThis);
            hour = hour + dayTime;
            expectedTemperatureBar.add(hour);
        }
        expectedTemperatureBar.set(0, "Now");
        return expectedTemperatureBar;
    }

    public void clickOnTodaysTimeline() {
        //scrollToElement(todaysTimeline);
        clickOn(todaysTimeline);
    }

    public String getMinTempFromTodaysTimeline() {
        return getTextFromElement(todaysTimeLineMinTemp).trim();
    }

    public String getMaxTempFromTodaysTimeline() {
        return getTextFromElement(todaysTimeLineMaxTemp).trim();
    }

    public String getLowTempFromTodaysDetail() {
        return getTextFromElement(lowTempFromTodaysDetail).trim();
    }

    public String getHighTempFromTodaysDetail() {
        return getTextFromElement(highTempFromTodaysDetail).trim();
    }

    public void verifyLowHighTempIsDisplayedCorrectlyInTodaysDetail() {
        String lowTempFromTodaysDetail = getLowTempFromTodaysDetail();
        String highTempFromTodaysDetail = getHighTempFromTodaysDetail();

        String lowTempFromTodaysTimeline = getMinTempFromTodaysTimeline();
        String highTempFromTodaysTimeline = getMaxTempFromTodaysTimeline();

        DoVerification.isTwoStringsEquals(getLowTempFromTodaysDetail(), getMinTempFromTodaysTimeline());
        DoVerification.isTwoStringsEquals(getHighTempFromTodaysDetail(), getMaxTempFromTodaysTimeline());
/*
        if(!lowTempFromTodaysDetail.equals(lowTempFromTodaysTimeline) || !highTempFromTodaysDetail.equals(highTempFromTodaysTimeline)) {
            *//*System.out.println(lowTempFromTodaysDetail);
            System.out.println(highTempFromTodaysDetail);
            System.out.println(lowTempFromTodaysTimeline);
            System.out.println(highTempFromTodaysTimeline);*//*
            Assert.fail("Low or high temperature in today's detail is not displayed as expected");
        }*/
    }


}
