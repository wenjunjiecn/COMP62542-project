## Start the whole system

Update: We have deployed our system on a cloud server. 
			   The url for the cloud server is ~~https://studentsystem.tech/landing~~
			   (The website is currently inaccessible because the free server has expired.)

To start the whole system, you need to run the Java file named "*StudentSystemApplication.java*", located at "./src/main/java/com/uom/cs/studentsystem".

The link to Home page of the system is: http://localhost:8080/landing

<img src="images/landing page.png" style="zoom:50%;" />

- Student System

  - Clicking the <u>Student System</u>, you will go to the login page. In login page, students can log into their student system.

- Student Support Office

  - Student Support Office is implemented for task 6.

  - In Student Support Office, we will allow the **Student Support Sffice to add or remove some courses** from student's course list.

    <img src="images/StudentSupport.png" style="zoom:50%;" />

- Student Union

  - Student Union is implemented for task 5.

  - In Student Union, we implemented two functions:

    1. **Create a newsletter** and save them into the database
    2. **Notify all subscribers**. That means the Student Union will send newsletter to student's inbox in the Student System.

    <img src="images/StudentUnion.png" style="zoom:50%;" />

- Student Admission Office

  - Student Admission Office is implemented for task 7.

  - In Student Admission Office, we implemented two functions:

    1. **Create a daily reminder** and save them into the database
    2. **Notify all students with pending status**. 

    <img src="images/StudentAdmissionOffice.png" style="zoom:50%;" />

  

<div STYLE="page-break-after: always;"></div>

## Login to the student system

Methods to visit login page:

- Visit login page via: http://localhost:8080/login 
- Click the <u>Student System</u> in Homepage

<img src="images/loginPage.png" style="zoom:50%;" />

In the student system, we have three users with different registration status:

| User      | Student ID | Registration Status |
| --------- | ---------- | ------------------- |
| Student 1 | 11111      | Not Register        |
| Student 2 | 22222      | Fully Register      |
| Student 3 | 33333      | Pending             |

After the student logging into the system successfully, the student will see the following page:

<img src="images/homePageForStudentSystem.png" style="zoom:50%;" />

<div STYLE="page-break-after: always;"></div>

## Timetable for students

Remind: please login with the Student ID $11111$ continue this part.

Click the button <u>Timetable</u> at the top of the page to view the timetable.

<img src="images/timetableOverview.png" style="zoom:50%;" />

Click the blue button <u>Add Activity</u> to add additional activities.

<img src="images/timetableAddActivity.png" style="zoom:50%;" />

Student can delete an activity by first clicking the activity on timetable, and then clicking the delete button.

<img src="images/timetableDeleteActivity.png" style="zoom:50%;" />

## Choose or opt-out optional courses

Click the button <u>Optional Course</u> at the top of the page to view the optional course unit.

<img src="images/timetableChooseOptionalCourses.png" style="zoom:50%;" />

Student can choose or opt-out a course by clicking the button.

## Subscribe or unsubscribe newsletter

Click the button <u>Subscribe Center</u> at the top of the page to view the subscribe center.

<img src="images/subscribeCenter.png" style="zoom:50%;" />

In the student system, students can subscribe up to three types of newsletters published by the Student Union.

Students can view their subscribe status on the second column, and change their subscribe status by clicking the button <u>Subscribe</u> or <u>Unsubscribe</u> on the third column.

## Create and publish newsletters in Student Union

Click the <u>Student Union</u> at Home Page(http://localhost:8080/landing) to get into the Student Union.

The Student Union can create different types of newsletters, including \"Academic\", \"Sports\", and \"Social\".

<img src="images/StudentUnionAddContent.png" style="zoom:50%;" />

To submit the newsletter to the database, the student union needs to click the button <u>Submit</u>.

To publish the newsletters to the student who subscribe them, the student union can click the button \"Notify All Subscriber\".

## Notification Center for newsletters and daily reminder

Click the button <u>Notification Center</u> at the top of the page to view the notification center.

In the notification center, students can read the newsletters published by the Student Union.

<img src="images/notificationCenterForNewsletterAndDailyReminder.png" style="zoom:50%;" />

To view the content of the message, the student can click the button <u>Open</u>.

<img src="images/contentOfMessage.png" style="zoom:50%;" />

## Student Support Office adds or removes courses

Click the <u>Student Support Office</u> at Home Page(http://localhost:8080/landing) to get into the Student Union.

<img src="images/StudentSupport.png" style="zoom:50%;" />

The student support office can add or remove some courses from student's course list by clicking the button.

<div STYLE="page-break-after: always;"></div>

## Student Admission Office sends daily reminder

Click the <u>Student Support Office</u> at Home Page(http://localhost:8080/landing) to get into the Student Union.

<img src="images/createDailyReminder.png" style="zoom:50%;" />

The Student Support Office can write daily reminder in this page.

To submit the daily reminder to the database, the student union needs to click the button <u>Submit</u>.

To send the daily reminder to the pending students, the Student Support Office can click the button \"Notify All Pending Student\".

## Check the daily reminder

To check the daily reminder, you need to login the account of a pending student. In our database, the student with ID $33333$??? is pending for registration.

Therefore, you need to click the button <u>Logout</u> to logout $11111$, then login into the student system with $33333$.

Click the button <u>Notification Center</u> at the top of the page to view the notification center.

<img src="images/dailyReminder.png" style="zoom:50%;" />

To view the content of the daily reminder, the student can click the button <u>Open</u>.

<img src="images/dailyReminder2.png" style="zoom:50%;" />

## Thanks for reading!

