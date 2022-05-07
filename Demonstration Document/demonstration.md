## Start the whole system

The link to Home page of the system is: http://localhost:8080/landing

<img src="E:\曼大学习\2nd Semester\COMP62542 Pattern-Based Software Development 2021-22 2nd Semester\Demonstration Document\landing page.png" style="zoom:50%;" />

- Student System

  - Clicking the <u>Student System</u>, you will go to the login page. In login page, students can log into their student system.

- Student Support Office

  - Student Union is implemented for task 6.

  - In Student Union, we will allow the **Student Support Sffice to add or remove some courses** from student's course list.

    <img src=".\StudentSupport.png" style="zoom:50%;" />

- Student Union

  - Student Union is implemented for task 5.

  - In Student Union, we implemented two functions:

    1. **Create a newsletter** and save them into the database
    2. **Notify all subscribers**. That means the Student Union will send newsletter to student's inbox in the Student System.

    <img src=".\StudentUnion.png" style="zoom:50%;" />

- Student Admission Office

  - Student Admission Office is implemented for task 7.

  - In Student Admission Office, we implemented two functions:

    1. **Create a daily reminder** and save them into the database
    2. **Notify all students with pending status**. 

    <img src=".\StudentAdmissionOffice.png" style="zoom:50%;" />

  

## Login to the student system

Methods to visit login page:

- Visit login page via: http://localhost:8080/login 
- Click the <u>Student System</u> in Homepage

<img src=".\loginPage.png" style="zoom:50%;" />

In the student system, we have three users with different registration status:

| User      | Student ID | Registration Status |
| --------- | ---------- | ------------------- |
| Student 1 | 11111      | Not Register        |
| Student 2 | 22222      | Fully Register      |
| Student 3 | 33333      | Pending             |

After the student logging into the system successfully, the student will see the following page:

<img src=".\homePageForStudentSystem.png" style="zoom:50%;" />

