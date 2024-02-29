

# Display Bookshelves


This Automation project is written in Selenium and it tests the urbanladder website using TestNG and Cucumber frameworks.
 The process for the automation are as follows
 


### Installation

 - Eclipse as a platform for writing selenium scripts
 - Cucumber used for implementing the test scripts
 - Apache POI for Collecting data in the Excel File
 - TestNG used to implement the test cases.
    
### Dependencies

###### Selenium 
<dependency>
    
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.17.0</version>
</dependency>

###### Apache POI
<dependency>

    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.2.5</version>
</dependency>

<dependency>

    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.4</version>
</dependency>


###### Cucumber
<dependency>

    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.15.0</version>

</dependency>

###### TestNG
<dependency>

    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
</dependency>	

###### ExtentReports
<dependency>
	
    <groupId>tech.grasshopper</groupId>
	<artifactId>extentreports-cucumber7-adapter</artifactId>
	<version>1.14.0</version>

</dependency>
	
### Automation process
1. Search for "BookShelves" with price below Rs. 15000
2. Select any one Category and exclude out of stock.
3. Sort by price "High to Low", fetch the top 3 items & print all details in console output.
4. From Living, retrieve all items under any one of sub-menu items like  "Seating & Chairs" or "Living Storage".
5. Also print the same in console output.
6. Under "Gift cards", choose "Birthday/Anniversay" 
7. Fill "Customize your gift card" with valid price & date and click "Next" button
8. Fill "To" & "From" details under "who is this lucky person" with any one email id invalid (example: without @ symbol) and click "Submit".
9. Capture & display the error message in console output.
10. Then give valid email id & validate all the given details in the "Confirm Details" section


### Sources 

##### Maven Repository
- https://mvnrepository.com/

##### Url of urbanladder
- https://www.urbanladder.com/

### In the Project
- Selenium
- Apache POI
- Cucumber 
- TestNG
- POM (Page Object Model)
- Logs
- Reports

### Key Automation Scope
- Handling alert, drag & drop search option

- Extract menu items & store in collections

- Navigating back to home page

- Scrolling down in web page

- Filling form (in different objects in web page)

- Capture warning message