# 🛍️ AutomationInTesting Cucumber-TestNG Hybrid Framework

This is a real-time automation testing framework built to automate Shady Meadows B&B Room search & Booking scenarios using:

- ✅ Selenium WebDriver
- ✅ Cucumber BDD (Gherkin syntax)
- ✅ TestNG (as runner)
- ✅ Apache POI for Excel data
- ✅ Extent Reports with Screenshot Support
- ✅ Retry Analyzer for flaky test handling
- ✅ Tag-based test execution
- ✅ GitHub Integration

![Java](https://img.shields.io/badge/Java-11+-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![TestNG](https://img.shields.io/badge/TestNG-7.9-orange)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-green)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-yellow)

---

## 📁 Project Structure

HybridAutomationFramework/


├── features/                   
│   ├── RoomBooking.feature
│   └── RoomBookingExcel.feature
│

├── stepdefinitions/           
│   ├── RoomBookingSteps.java
│   └── RoomBookingExcelSteps.java
│

├── pages/           
│   ├── ContactFormPage.java
│   └── RoomBookingPage.java
│

├── hooks/                     
│   ├── Hooks.java
│   ├── CucumberStepHolder.java
│   └── ExtentReporterHooks.java
│

├── base/                  
│   └── BaseTest.java
│

├── utils/                     
│   ├── ExcelUtil.java
│   ├── ScreenshotUtil.java
│   ├── StepLogger.java
│   ├── ExtentManager.java
│   ├── ConfigReader.java
│   ├── RetryAnalyzer.java
│   └── RetryListener.java
│

├── testdata/                  
│   └── TestData1.xlsx
│

├── reports/                   
│   └── ExtentReport.html
│

├── docs/                     
│   ├── Test-Plan.md
│   └── Bug-Report.md

├── screenshots/               
│   └── (failure screenshots generated at runtime)
│

├── runner/                    
│   └── TestNGCucumberRunner.java
│

├── testng.xml                 
├── pom.xml                    
└── README.md                  


---

## 🧪 How to Execute Instructions

### ▶️ From IDE (Eclipse/IntelliJ)
- Right-click `testng.xml` → **Run As → TestNG Suite**

### 🏷️ Tag Based Execution

You can filter tests using tags in the runner class:
```java
tags = "@booking"

📸 Reporting & Logs
✅ Extent Report: reports/ExtentReport.html

✅ Cucumber HTML: target/cucumber-reports/index.html

✅ Failure Screenshots: screenshots/ScenarioName_Timestamp.png

📊 Data-Driven Testing
✅ Excel file: testdata/SearchData.xlsx

✅ Powered by: Apache POI

✅ Scenario: SearchExcel.feature

📌 Tags
Tag	Description
@ExcelSearch	Excel-driven test scenario

@Smoke	Smoke tests
@sanity Sanity tests

💻 Tech Stack
Layer	Technology
Language	Java 11+
Automation Tool	Selenium WebDriver
BDD Framework	Cucumber
Runner	TestNG
Build Tool	Maven
Reports	Extent Reports, Cucumber HTML
Data-Driven	Apache POI (Excel support)
VCS	Git + GitHub

👨‍💻 Author
👤 Name: Nisha Balodi

🌐 GitHub: NBAutomate

📧 Email: nishabalodi@gmail.com
🔗 LinkedIn: linkedin.com/in/nishabalodi


🔮 Future Enhancements
✅ JSON,Excel Data Support

✅ Allure Reporting Integration

✅ Jenkins CI/CD Pipeline

✅ Docker Grid Execution Support

✅ Page Factory / Fluent Wait Refactor


