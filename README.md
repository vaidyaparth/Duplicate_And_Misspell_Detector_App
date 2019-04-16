# Validity_Exercise

Parth Vaidya (vaidya.pa@husky.neu.edu)

Application Details

* The application is built using Spring MVC
* The IDE that I have used here is NetBeans 8.2 
* I have used Apache Tomcat 9.0 server
* This application works for both normal and advanced csv

Take Home Exercise Overview

Exact Duplicates:
* For an entity to be considered duplicate first name, emailId and Phone number should be same.

Mispelled:
* A list of all the duplicates and minor changes in spelling(not more than two character) are included.

 
Steps to run the Application

* Download the Apache Tomcat Server (https://tomcat.apache.org/download-90.cgi)
* I have used some external jar files like opencsv-4.0.jar, commons-dbcp2-2.6.0.jar, commons-dbutils-1.7jar which can be found inside   Validity_Demo\build\web\WEB-INF\lib
* To run the application please change the file path of csv inside CSVDataWithNoDuplicate method under class DuplicateCheck.java inside package com.validity.checker (For ex: File ff = new File("\\src\\java\\resources\\normal.csv");)
* The url of the application is (http://localhost:8004/Validity_Demo/index.htm). In my case the port for tomcat is 8004 which can be different in your case

1. The application opens with
![image](https://user-images.githubusercontent.com/46656994/56183941-63068800-5fe6-11e9-93ad-24ac7dba8771.png)

2. 

