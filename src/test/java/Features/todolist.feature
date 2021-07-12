Feature: Todo List

Background:
  Given Open todo mvc url
  Then  User Verify mvn url loaded Successfully
  When  User Add todo "Task1","Task2" and "Task3"
  @Scenario1
  Scenario: Create Todo List and Verify
    Then User Verify Todo list created and added to todo list successfully
  @Scenario2
  Scenario: Validate Complete Todo List
    Then User Verify Todo list created and added to todo list successfully
    When  User Complete the task "Task1"
    And   User Click on Complete Button
    Then  User Should see "Task1"
  @Scenario3
  Scenario: Validate Active Todo List
    Then User Verify Todo list created and added to todo list successfully
    When  User Complete the task "Task1"
    And   User Click on Active Button
    Then  User Should see "Task2" and "Task3"
  @Scenario4
  Scenario: Validate Clear Completed Todo List
    Then User Verify Todo list created and added to todo list successfully
    When  User Complete the task "Task1" and "Task2"
    And   User Click on Clear Completed Button
    Then  User Should see only "Task3"
    When  User Click on Active Button
    Then  User Should see only "Task3"
  @Scenario5
  Scenario: Delete Active Todo List
    Then User Verify Todo list created and added to todo list successfully
    When  User delete the task "Task1"
    And   User Click on Active Button
    Then  User Should see "Task2" and "Task3"
  @Scenario6
  Scenario: Mark all Todo as complete
    Then User Verify Todo list created and added to todo list successfully
    When  User Mark all task complete
    And   User Click on Active Button
    Then  User Verify all todo list items are complete successfully