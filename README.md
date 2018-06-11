# UrlShortener
This project is created using Angular-6 for the Front-end(which is there as separate repository in my GitHub acount), 
Spring boot framework for the server side coding and Mongo DB as the database.

![alt text](https://github.com/saishashaankvv/urlshortener/blob/06bc323904755d805b00a6c426b0333839afbc03/Screenshot%20(2).png?raw=true)

# Launching the Project
Open the spring Boot project in any of the editor like Eclipse or IntelliJ Idea and locate the main class `UrlshoetnerApplication.java`
in the  package `com.assignment.urlshortner` inside src/main/java folder and run it and the application will get launched.
Dump of Frontend(which is developed using Angular-6 was placed in `src/main/resources/static` folder.
open the application in browser using the url `localhost:3000` or `ip-address:3000`(as the project is configured on the port 3000).

# Server port Configuration
Configuration of server port was done in `applications.properties` file, So the server will start running in port-3000.

# Database Configuration
Database Configuration was written in the file `MonngoDBConfig.java` inside the package `com.assignment.urlshortner.Config`.
By default database will be running in the port 27017.

# Algorithm
Algorithm which is used in this project to shorten the urls is placed in the package `com.assignment.urlshortner.alogorithm`.

