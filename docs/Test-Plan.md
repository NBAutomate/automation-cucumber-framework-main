# TEST PLAN

This document outlines the test approach, scope, and strategy for the AutomationInTesting website. It describes how Java, Selenium 4, and supporting tools are used to automate functional and non-functional tests for booking workflows and the contact form. The plan focuses on showcasing maintainable, scalable test automation.

## Document Information

| Field | Description |
|-------|-------------|
| Project name | AutomationInTesting - ShadyMeadows BnB |
| Website URL | https://automationintesting.online/ |
| Test Tool/Technology | Java, Selenium 4, TestNG, Maven |
| Version Number | 1 |
| Authored Date | 13-Jul-2025 |
| Author | Nisha Balodi |

## Contents

- [1 Introduction](#1-introduction)
    - [1.1 Purpose](#11-purpose)
    - [1.2 Overview](#12-overview)
    - [1.3 Scope](#13-scope)
- [2 Test Strategy](#2-test-strategy)
    - [2.1 In Scope](#21-in-scope)
    - [2.2 Out of Scope](#22-out-of-scope)
    - [2.3 Test Components](#23-test-components)
    - [2.4 Testing Strategy](#24-testing-strategy)
    - [2.5 Test Case Management](#25-test-case-management)
    - [2.6 Defect Management](#26-defect-management)
    - [2.7 Defect Severity](#27-defect-severity)
- [3 Suspension Criteria and Resumption Requirements](#3-suspension-criteria-and-resumption-requirements)
- [4 Roles and Responsibilities](#4-roles-and-responsibilities)
- [5 Schedule](#5-schedule)
- [6 Testing Deliverables](#6-testing-deliverables)
- [7 Assumptions and Dependencies](#7-assumptions-and-dependencies)
- [8 Risks and Contingencies](#8-risks-and-contingencies)
- [9 Glossary](#9-glossary)

## 1 Introduction

### 1.1 Purpose

The purpose of this test plan is to define the approach for automated testing of the AutomationInTesting website using Java and Selenium 4. It demonstrates skills in functional and non-functional automation testing.

### 1.2 Overview

This test plan details the test scope, strategy, tools, and deliverables for automating key functionalities such as booking, authentication, and contact form validation. The framework uses Java, Selenium 4, TestNG/JUnit, and Maven.

### 1.3 Scope

Scope includes:
- Booking workflows
- Contact form
- Negative booking scenario
- Basic performance checks

**Non-Functional Checks**
- Basic performance sanity: page load within acceptable time
- Visual consistency: screenshots on failure

## 2 Test Strategy

### 2.1 In Scope

- Functional test automation
- Smoke and regression tests
- Non-Functional test automation: Basic Performance, Accessibility check
- Defect logging

### 2.2 Out of Scope

- Payments (Not applicable)
- Extensive performance check
- Security and API testing

### 2.3 Test Components

Tests will cover:
- Home Page UI
- Booking Page UI
- Booking Completion
- Contact Form submission

### 2.4 Testing Strategy

- Tests can be run using tags in Runner file like smoke, sanity, regression
- Parallel Execution: Tests run concurrently for efficiency
- Retry Mechanism: Flaky test handling
- Reporting: HTML reports with screenshots on failure
- CI/CD Integration: GitHub Actions ready

### 2.5 Test Case Management

Test cases will be maintained within the framework repository with clear structure and execution reports.

### 2.6 Defect Management

Defects will be tracked in GitHub Issues or a local tracker.

### 2.7 Defect Severity

- Blocker – Stops execution
- Major – Breaks key flows
- Minor – Non-critical issues
- Trivial – UI or cosmetic issues

## 3 Suspension Criteria and Resumption Requirements

Testing will be paused for critical blockers or environmental issues and will resume once resolved.

## 4 Roles and Responsibilities

- **Role:** Automation Engineer – Nisha
- **Responsibilities:** Design, develop, execute automation, report results.

## 5 Schedule

| Phase | Start | End |
|-------|-------|-----|
| Planning | 10-Jul-2025 | 11-Jul-2025 |
| Development | 11-Jul-2025 | 12-Jul-2025 |
| Execution | 12-Jul-2025 | 13-Jul-2025 |

## 6 Testing Deliverables

- Test Plan
- Automation Code (GitHub)
- Execution Reports: Built-in HTML reports, Screenshots & traces for failures
- README.md

## 7 Assumptions and Dependencies

- Website stays available
- Browsers and tools are configured

## 8 Risks and Contingencies

- **Risk:** Website instability – Use waits and retries
- **Risk:** Limited time – Prioritise critical flows

## 9 Glossary

- UI – User Interface
