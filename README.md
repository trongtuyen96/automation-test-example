<h1 align="center">
  <br>
  <a href="background"><img src="https://github.com/trongtuyen96/automationTestExample/blob/master/Background_with_title.PNG" alt="background"></a>
  <br>
  Automation Test Example
  <br>
</h1>

<h3 align="center" style="bold">Simple automation test examples based on Selenium, TestNG framework with some cool features</h3>

## Table of Contents
- [Sanmple Test](#sample-test)
- [Data Provider Test](#data-provider-test)
- [ExcelPOI Test](#excelpoi-test)
- [Multi Browser Test](#multi-browser-test)
- [ATWT Page Test](#atwt-page-test)
- [ATWT Page Factory Test](#atwt-page-factory-test)
- [ExtentReport Test](#extentreport-test)
- [Retry Analyzer Test](#retry-analyzer-test)
- [Real Time Result Test](#real-time-result-test)
- [Parallel Test With Consolidated Report](#parallel-test-with-consolidated-report)
- [Author](#author)
- [License](#license)

## Sample Test
An example where setting up an chrome driver, run simple test and validate result.
- Related classes: MyWebDriverManager for setting up web driver
- SUT: google.com
- Tests: validate search results


## Data Provider Test
Apply dataProvider annotation from TestNG to parameterized input data.
- Related files/classes: MyWebDriverManager for setting up web driver
- SUT: clculator.com
- Tests: validate add calculations, there are 2 tests run with data passing by returned object of @DataProvider annotation

## ExcelPOI Test
Data-Driven with data read from Excel file, excel utilities provided.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- ExcelUtis for reading data from excel files
	- Data.xlsx is excel file test data
- SUT: clculator.net
- Tests: validate add calculations, there are 2 tests run with data passing by returned object of @DataProvider annotation

## Multi Browser Test
Execute test on multiple browsers, parallel run allowed.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- MultiBrowser.xml for running on multiple browsers
	- Parallel.xml for running parallelly
- SUT: automatedtestingiwthtuyen.com
- Tests: validate current url of page, the browser to run is parameterized by setDriver function

## ATWT Page Test
An test with test page (automatedtestingwithtuyen.com) were built following Page Object Model.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- ATWTHomePage class to define locators and functions
- SUT: automatedtestingiwthtuyen.com
- Tests: validate navigation to forum, author pages and search results

## ATWT Page Factory Test
An test with test page (automatedtestingwithtuyen.com) were built following Page Factory.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- ATWTHomePageFactory class to define locators, functions and set up page factory
- SUT: automatedtestingiwthtuyen.com
- Tests: validate navigation to forum, author pages and search results

## ExtentReport Test
Apply ExtentReport to generate beautiful, fully-detailed, well-organized result report. Fail screenshots captured.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- extent-config.xml to format extent report
	- report is generated under test-output/ExtentReport_yyyyMMddhhmmss
	- screenshot is located at test-output/screenshots
- SUT: calculator.net
- Tests: validate calculation results, failed cases will be captured with screenshots in report

## Retry Analyzer Test
Automatically retry to execute failed test cases.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- RetryAnalyzer with retry count up to 2 times
	- AnnotationTransformer to execute annotations at runtime
	- Retry.xml to run test via execution file
- SUT: google.com
- Tests: validate results, the test was forced to fail to check retry feature

## Real Time Result Test
Test results are synced in near real time by combination of InfluxDb and Grafana dashboard (with Docker containerized).
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- InfluxDBManager to set up DB connection, DB name and instance
	- InfluxDBListener to write data on test results
	- docker-compose.xml to set up Grafana and InfluxDB containers
	- grafana-datasource.xml to set up datasource for Grafana
	- InfluxDB_Grafana.xml to execute test
- SUT: github.com
- Tests: validate overview page, repository page and test results are synced up in Grafana localhost:3000
- To build containers: 
	```bash
	docker-compose up -d influxdb grafana
	```
	
## Parallel Test With Consolidated Report
Tests are run parallely and one consolidated report is generated for total results.
- Related files/classes: 
	- MyWebDriverManager for setting up web driver
	- ExtentManager to set up Extent report
	- ExtentTestManager to set up methods for logging test on Extent report 
	- ParallelTestWithReport.xml to set up parallel runs by test methods
	- Report is located at /test-ouput
- SUT: automatedtestingwithtuyen.com
- Tests: validate patterns page, tools page and frameworks page current urls.


Addition: Dynamically find the suitable web driver (chromedriver, firefoxdriver, etc) against multiple versions in runtime via WebDriverManager.

## Author
<h4 align="center">
	Tuyen Nguyen - QA Automation Engineer
	</h4>
	<h5 align="center">
	<a href="trongtuyen96@gmail.com">trongtuyen96@gmail.com</a>
	</h5>
<p align="center">
	 <a alt="Github" href="https://github.com/trongtuyen96">
    <img src="https://user-images.githubusercontent.com/25218255/47360756-794c1f00-d6fa-11e8-86fa-7b1c2e4dda92.png" width="50">
  </a>
		 <a alt="LinkedIn" href="https://www.linkedin.com/in/tuyennguyen96/">
    <img src="https://user-images.githubusercontent.com/25218255/47360366-8583ac80-d6f9-11e8-8871-219802a9a162.png" width="50">
  </a>
		 <a alt="Facebook" href="https://www.facebook.com/ntrongtuyen96">
    <img src="https://user-images.githubusercontent.com/25218255/47360363-84eb1600-d6f9-11e8-8029-818481536200.png" width="50">
  </a>
</p>

## License
~~~~
Copyright 2020 Tuyen Nguyen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
~~~~
