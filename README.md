# Mentoring
The goal of the project is to provide a backend application that will enable the front-end team to integrate the previously created UI.
## Table of contents
* [General info](#general-info)
* [Functions](#functions)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is a back-end application facilitating REST API that allows the student to book a time and date with a mentor during irregular availability hours. After making the reservation, both persons are informed by e-mail about the appointment. The project was developed as part of a hacktics project from Euvic. 
## Functions
- 15-minute meetings
- max 5 reservations per month
- documentation created with Swagger
- after the reservation is made, e-mail containing confirmation is send 
## Technologies
Project is created with:
- Spring Boot version: 2.3.1
- Java version: 1.8
- Hibernate
- GitLab
- MS Sql Server
- Swagger version: 3.0.0
- Lombok
## Setup
To run this project:
<ol><li>Allow application to establish connection with database using one of following methods
Create „Mentoring” database using MS SQL Server with user mentoring with password qwerty or Change following lines in application.properties file:

<pre>spring.datasource.url=jdbc:sqlserver://localhost;databaseName=Mentoring
spring.datasource.username=mentoring
spring.datasource.password=qwerty 
</pre></li>

<li>Adapt email user to properly send confirmation email in application.properties file:
<pre>spring.mail.username=
spring.mail.password=
</pre></li>
<li>Install Maven and Java minimum 1.8 </li>

<li> Open terminal and go to root directory of project.
To start application type: <pre> Mvn spring-boot:run </pre></li>

<li>To see all available endpoints go to address:
<a href="http://localhost:8081/mentoring/v2/api-docs"> Click here </a>
</li></ol>
