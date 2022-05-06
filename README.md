# Individual project - 202
 
# Pavan Karthik Gollakaram
 Student id : 015945670

# Problem Statement 

Design and implement a Java application which maintains an internal, static database. There is a limit on the number of items like Essentials are restricted to a maximum of 3, Luxury to 4, and Miscellaneous to 6. The application validates if the requested quantity for each item is permissible or not. Once the validation is done, if the cart is valid, application adds prices and displays the total amount and card details will be used for payment process else displays a txt file - Please correct quantities.

# Instructions to run the application

Go to repo individual-project-pavankarthikg and clone the repository or download the zip file.
You need Visual studio code IDE or Eclipse IDE to run the code. Open the zipped folder or the entire folder in your preferred IDE.

After opening the project go to src --> Billing.java, compile and run the project.

If the java version is not compatible please download the correct JDK version ( Oracle JDK 17).
* Install java extensions in visual studio code.

# For MaVeN installation
```mvn clean install```

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Setting up

Make sure you have the latest Java JDK version. The version used in this development: 17.0.2 2022-01-18

# Design Patterns 

Singleton Pattern

Chain of Responsibility

# Singleton
This creational pattern involves a single class which is responsible to create an object while making sure that only single object gets created and provides a way to directly access its only object without the need to instantiate the object of the class.

We used this pattern to build database for the system. The system stores a data from in-memory database therefore we used singleton pattern so that we will get same instance of data throughout the operations.

# Chain of Responsibility
In the chain of responsibility pattern, a request from the client is passed to a chain of objects to process them. Later, the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

This is a behavioral pattern. The application used this pattern to process the order requests validation.  First It loads input files, validates if the items are present in database, moves to validate the order as per the limited quantity and then adds the total amount to be displayed.

# 3 Test cases

1. Implementing the sample input given.
<img src="/screenshots/rightInput.png" alt="Sample input and ouput" title="Sample input and output">
<img src="/screenshots/rightoutput.png" alt="Sample input and ouput" title="Sample input and output">
2. Testacse #2
<img src="/screenshots/input3.png" alt="Sample input and ouput" title="Sample input and output">
<img src="/screenshots/input3_OP.png" alt="Sample input and ouput" title="Sample input and output">
3. Error generating testcase.
 <img src="/screenshots/errortext11.png" alt="Sample input and ouput" title="Sample input and output">
<img src="/screenshots/errortextOutput.png" alt="Sample input and ouput" title="Sample input and output">