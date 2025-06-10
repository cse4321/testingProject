### PureNameCheck

*PureNameCheck* is created as an example to show how to write JUnit test methods.

**Class** *PureNameCheck* contains:

- A **main** method and 
- Two **regular** methods: 
  + *checkPureName* 
  + *getNameFromSystemIn*

**Two test classes**: 
- *TestMain*: for end-to-end testing containing two test methods via testing the **main** method.

- *TestRegularMethods*: for unit testing containing the test methods that test the  **regular** methods (non-main methods).


<hr>

### Set up with VS Code
1, Launch VS Code

2, Install "Extension Pack for Java" via "Extensions" icon.

3, Import as a project
  - File -> Open Folder....
  - Select the root directiry of the project.
  - Click 'Select Folder'.

<hr>


### Generate two HTML coverage reports
The coveage report must show the code coverage of the **program under the test** and the **tests** themselves. In this way, we can tell which tests contribute to the coverage and thus distinguish end-to-end testing and unit testing. 

- Configure the **pom.xml** file. Change the value of the "scope" tag from "test" to "main" in the dependency blocks of "org.junit.jupiter".

- Organize the test files
  + End-to-end testing. Put all the tests of the main method in one test file (eg. the TestMain.java).
  + Unit testing. Put all the tests of the non-main methods in another test file (eg. the TestRegularMethods.java).
  + Copy these two test files where the program under the test is.
  
- Execute test files
  + For end-to-end testing
    * Only keep the test file for the end-to-end testing in "./src/test/java/com/".
    * Remove all the other test files.
    * Execute "mvn clean verify" in the terminal

  + For unit testing, apply the same way as the end-to-end testing.

- Check code coverage 
  + A coverage report consists of all the files and folders in the "./target/site/jacoco/". An example is shown below:

    ![converage files](./img/eg_coverage_report_files.jpg)

  + Open the "index.html" to view code coverage. The coverage for end-to-end testing in this branch is given below:
  ![converage files](./img/coverage-end-to-end.jpg)
  The code coverage achieved here is 94%. Only the tests in the TestMain.java are executed to achieve this coverage. Hence this is the coverage report for the end-to-end testing. 


