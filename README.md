# Project Title
e-Timesheet web application.

## Overview
It is a school project for Agile DevOps and Code Mgmt modules.
The e-timesheet allows the employees to capture their working hours and leave applications digitally. It should be able to perform auto-tabulation and validation of the entry and automated the approval process.

## Table of Content
[installaton]
[Features]
[Databases]
[Contributors]
[Contact]

## Installation
instruction on how to install the project. The project is currently still work in progress and hence there is no installation guide.

## Features
- Login page for users to log in. [completed: launch.jsp]
- Administrator to view all employees record [completed: usermanagement.jsp]
-	Administrators to Add / delete / modify employee records [Completed: register.jsp, useredit.jsp]
-	Employee to input his\her working hours on the e-timesheet and submit online
-	Employee to apply and submit his/her leave application.
-	Dashboard for employeee to view his/her personal record, timesheet record and leave records.
-	Analytical dashboard for administrators to view employees records, timesheet and leave for all employees
-	Automate the approval workflow online.

## Databases
There are 3 databases that is linked to the project
### -----------------------------
    Database #1: emp_datadetails
    Content: store employees personal data and leave entitlement
    ==database dictionary==
    EmpID = employee id; FirstName = employee first name; LastName = employee last name; DOB = date of birth
    PayGrade = employee current pay grade; EmpDate = employee joined date (date of employment)
    ComEmail = employee company email; Mobileph = employee mobile number
### ----------------------------
    Database #2: emp_leaves
    Content: store employee leave application
    ==database dictionary==
    EmpID = employee id; LeavID = leave id generated for each leave application transaction
    Starts = the start date of the leave; Ends = the end date of the leave
    Total = number of leave (in days) applied per line
    Information = additional info that the employee would want to indicate in his leave application
    AppStatus = approval status of the leave applicate per line
### ----------------------------
    Database #3: emp_timesheet
    Content: store employee timesheet record per week
    ==database dictionary==
    EmpID = employee id; TSHID = timessheet id generate per active employee per week
    WeekNYear = week per calendar year; DateRange = dates of the week per calendar year
    Monday = monday of the week; Tuesday = tuesday of the week; Wednesday = wednesday of the week
    Thursday = thursay of the week; Friday = friday of the week;
    Saturday = saturday of the week; Sunday = sunday of the weekl
    TotalHR = total hours work per line entry
    Information = additional imfo that the employee would want to indicate to explain the entry

## Contributors
6562515M@polite.edu.sg

## Contact
this is the contact information for the code owners

