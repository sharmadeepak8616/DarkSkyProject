package framework;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

    // This is the most common wait function used in selenium
    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(WrapperWebDriver.getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

	public void clickOn(By locator) {
		try {
            webAction(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void sendText(By locator, String text) {
		try {
            webAction(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void setValue(By locator, String text) {
		webAction(locator).sendKeys(text);
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = webAction(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
		return text;
	}

	public boolean isSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropDown(By dropDownLocator, String option) {
		WebElement dropDownElement = webAction(dropDownLocator);
		Select dropDown = new Select(dropDownElement);
		dropDown.selectByVisibleText(option);
	}

	public WebElement getWebElement(By locator) {
		WebElement element=null;
		try {
			element = webAction(locator);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	public List<WebElement> getWebElements(By locator) {
		List<WebElement> elements = null;
		try {
			elements = WrapperWebDriver.getDriver().findElements(locator);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
		return elements;
	}

	public void hoverOnElement(WebElement element) {
		Actions act = new Actions(WrapperWebDriver.getDriver());
		act.moveToElement(element).build().perform();
	}

	public void clickOnBrowserBackArrow() {
		WrapperWebDriver.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		WrapperWebDriver.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		WrapperWebDriver.getDriver().navigate().refresh();
	}

	public void clearText(By locator) {
		try {
            webAction(locator).clear();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void scrollToElement(By locator) {
    	JavascriptExecutor js = (JavascriptExecutor) WrapperWebDriver.getDriver();
    	WebElement element = WrapperWebDriver.getDriver().findElement(locator);
    	js.executeScript("arguments[0].scroolIntoView(true);" , element);
	}


}
