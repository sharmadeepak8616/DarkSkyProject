$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darkSky.feature");
formatter.feature({
  "line": 2,
  "name": "Dark Sky Feature",
  "description": "",
  "id": "dark-sky-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@darkSky"
    },
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on Dark Sky webpage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnDarkSkyWebpage()"
});
formatter.result({
  "duration": 299975884,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Verify timeline is displayed in correct format",
  "description": "",
  "id": "dark-sky-feature;verify-timeline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@tempbar-increment"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I verify timeline is displayed with 2 hours incremented for next 11 hours",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 36
    },
    {
      "val": "11",
      "offset": 65
    }
  ],
  "location": "DarkSkySD.iVerifyTempBarIncrement(int,int)"
});
formatter.result({
  "duration": 119080591,
  "error_message": "java.lang.NullPointerException\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:787)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:96)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:87)\n\tat framework.BasePage.webAction(BasePage.java:19)\n\tat framework.BasePage.getTextFromElement(BasePage.java:65)\n\tat framework.web_pages.DarkSky.HomePage.getActualTemperatureTimeline(HomePage.java:82)\n\tat framework.web_pages.DarkSky.HomePage.verifyTemperatureBarValues(HomePage.java:75)\n\tat stepdefinition.DarkSkySD.iVerifyTempBarIncrement(DarkSkySD.java:37)\n\tat ✽.Then I verify timeline is displayed with 2 hours incremented for next 11 hours(darkSky.feature:9)\n",
  "status": "failed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on Dark Sky webpage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnDarkSkyWebpage()"
});
formatter.result({
  "duration": 89840,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "dark-sky-feature;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@tempRangeInBottom"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I expand todays timeline",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iExpandTodaysTimeLine()"
});
formatter.result({
  "duration": 348428,
  "error_message": "java.lang.NullPointerException\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:787)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:96)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:87)\n\tat framework.BasePage.webAction(BasePage.java:19)\n\tat framework.BasePage.clickOn(BasePage.java:38)\n\tat framework.web_pages.DarkSky.HomePage.clickOnTodaysTimeline(HomePage.java:116)\n\tat stepdefinition.DarkSkySD.iExpandTodaysTimeLine(DarkSkySD.java:43)\n\tat ✽.When I expand todays timeline(darkSky.feature:13)\n",
  "status": "failed"
});
formatter.match({
  "location": "DarkSkySD.iVerifyLowHighTempIsDisplayedCorrectly()"
});
formatter.result({
  "status": "skipped"
});
});