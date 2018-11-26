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
  "duration": 7561481552,
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
formatter.step({
  "line": 10,
  "name": "close browser",
  "keyword": "And "
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
  "duration": 593077146,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.closeBrowser()"
});
formatter.result({
  "duration": 125557205,
  "status": "passed"
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
  "duration": 3837130359,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "dark-sky-feature;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@tempRangeInBottom"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "I expand todays timeline",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "DarkSkySD.iExpandTodaysTimeLine()"
});
formatter.result({
  "duration": 135436671,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iVerifyLowHighTempIsDisplayedCorrectly()"
});
formatter.result({
  "duration": 226115402,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.closeBrowser()"
});
formatter.result({
  "duration": 116191957,
  "status": "passed"
});
});