School Project - Code Management
Content: e-Timesheet web application
Purpose: The e-timesheet allows the employees to capture their working hours and leave applications digitally.

***Features to be implemented on application***
- Login page for users to log in. [completed: launch.jsp],[link: http://localhost:8090/Project/userservlets/dashboard]
-	Allow designated users to add / delete / modify employee records [Completed: register.jsp, useredit.jsp]
-	Allow designated users to view all employees record [completed: usermanagement.jsp]
-	Allow designated and payroll department to view timesheet report for all employees.
-	Allow employee to View/Edit employee’s personal data
-	Allow employee to update his/her working hours.
-	Allow employee to view his/her past records (timesheet)
-	Allow employee to view his/her leave entitlement and balance.
-	Allow employee to apply and submit leave application.
-	Automate the approval workflow online.

***Databases***
****************************
Database #1: emp_datadetails
Content: store employees personal data and leave entitlement
==database dictionary==
EmpID = employee id; FirstName = employee first name; LastName = employee last name; DOB = date of birth
PayGrade = employee current pay grade; EmpDate = employee joined date (date of employment)
ComEmail = employee company email; Mobileph = employee mobile number
****************************
Database #2: emp_leaves
Content: store employee leave application
==database dictionary==
EmpID = employee id; LeavID = leave id generated for each leave application transaction
Starts = the start date of the leave; Ends = the end date of the leave
Total = number of leave (in days) applied per line
Information = additional info that the employee would want to indicate in his leave application
AppStatus = approval status of the leave applicate per line
****************************
Database #3: emp_timesheet
Content: store employee timesheet record per week
EmpID = employee id; TSHID = timessheet id generate per active employee per week
WeekNYear = week per calendar year; DateRange = dates of the week per calendar year
Monday = monday of the week; Tuesday = tuesday of the week; Wednesday = wednesday of the week
Thursday = thursay of the week; Friday = friday of the week;
Saturday = saturday of the week; Sunday = sunday of the weekl
TotalHR = total hours work per line entry
Information = additional imfo that the employee would want to indicate to explain the entry



