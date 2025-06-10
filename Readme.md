### NameCheck

**Project** *PureNameCheck* is created as an example to show how to write JUnit test methods for methods that use *System.in* and *System.out*.

**Class** *PureNameCheck* contains:

- a **main** method and 
- two **regular** methods: 
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

br>
<hr>

### Execute a test file and generate a coverage report
1, Run a **test file** by right-clicking the file and selecting **Coverage as** -> **Junit Test**.

2, The **Coverage view** appears automatically along with the **Terminal** or **Console**. An example is shown below:

![Coverage View](./img/coverage_view1.jpg)

<br>
3, Generate an HTML Coverage Report by **right-clicking** some space in the Coverage view, **selecting** "Export Session", **choosing** "HTML format" and directory to save the report, and **clicking** "Finish" button.

An **complete example of an HTML Coverage Report** are shown below:

  ![An example of HTML coveage report](./img/an_example_HTML_coverage_report_with_related_files_and_folders.jpg)


### Generate two HTML coverage reports

- End-to-end testing: put all the tests of the main method in one test file and generate by executing this test file.
- Unit testing: put all the tests of the non-main methods in one test file  and generate by executing this test file.
