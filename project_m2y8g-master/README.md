# My Personal Project

## Ultimate Productivator

This project will consist of an application that is meant to be the ultimate tool for everyone's everyday needs
alongside being a tool that allows for users to relax or procrastinate within the 
comfort of their own desktops. The application will consist of mini tools that is meant to make life easier for 
students or harder for them to maintain their concentration. Quoting the great **Uncle Ben-** ***"With great power comes great responsibility"***

### Tools Available: 
- **Calculator** - A personal calculator that can do the following operands (+, -, /, *)
- **Binary Solver** - The tool that is most useful to computer science students. Allowing them to get the binary 
equivalent from their desktop. 
- **To-Do List** - A tool that allows for users to create a list of daily tasks, and sort them by completed and todo's.

### Distractions Available: 
- **Personal Tamagotchi** - Own your own personal digital pet and take care of him throughout your day.
- **Simon Says** - Earn food and other items for your Tamagotchi by playing a game of Simon Say's
- **Math Game** - Earn food and other items for your Tamagotchi by testing your mental math capabilities. 

### User Stories Available During Phase One : 
**Calculator:**
- As a user, I want to be able to input 2 numbers. 
- As a user, I want to be able to do the addition of 2 numbers. 
- As a user, I want to be able to do the subtraction of 2 numbers. 
- As a user, I want to be able to do the division of 2 numbers. 
- As a user, I want to be able to do the multiplication of 2 numbers.

**To-Do List:**
- As a user, I want to be able to add a new task to my To-Do List.
- As a user, I want to be able to view the completed tasks on my To-Do List.
- As a user, I want to be able to view the tasks on my To-Do List.
- As a user, I want to be able to mark a task as completed.


**Binary Solver** 
- As a user, I want to be able to input a number in unsigned binary 
- As a user, I want to be able to view the result of this binary number in decimal.
- As a user, I want to be able to view the result of this binary number in Hex.


### User Stories Available During Phase Two : 
**Personal Tamagotchi**
- As a user, I want to be able to create a new Tamagotchi with a certain Name
- As a user, I want to be able to view my Tamagotchi's name
- As a user, I want to be able to have the opportunity to load a file when I start the program
- As a user, I want to be able to have the opportunity to save a file when I close the program
- As a user, I want to be able to have the opportunity to load a file during the program
- As a user, I want to be able to have the opportunity to save a file during the program

**Personal Tamagotchi**
- As a user, I want to be able to view the name Tamagotchi.
- As a user, I want to be able to feed my Tamagotchi with items I acquire.
- As a user, I want to be able to earn items for my Tamagotchi. 


### CODE BIBLIOGRAPHY (EXTERNAL SOURCES USED):
- JSONSERIALIZATIONDEMO - https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
- Teller Application - https://github.students.cs.ubc.ca/CPSC210/TellerApp

**Phase 4: Task 2**
- Test and design a class in your model package that is robust.  You must have at least one method that throws a checked
  exception.  You must have one test for the case where the exception is expected and another where the exception 
  is not expected.
  This was implemented within the ToDoList Class where it throws an exception if a user tries marking a task complete 
  when the tasks are zero. 
 
**Phase 4: Task 3**
- If i had more time i would fully implement the Tamagotchi within the GUI aspect therefore there would be a relationship,
there between these two classes. Furthermore, i would also refractor the BinarySolverGUI and the MainGUI, this would 
ensure that the binarysolver portion of the application would work normally, instead of having to run it seperately. 
I would also make changes to the way that the data is saved within the application, saving the application as a whole 
instead of just saving the tamagotchi part of the application. 