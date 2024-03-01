# User Guide to ***Wallybot***

![Wallybot welcome message](wallybot_img.png)

Wallybot is a **personal assistant chatbot, optimised for use via a
Command Line Interface** (CLI).
It keeps track of your tasks and allows you to manage them!

- Features
  - [Adding a Todo: `todo`](#Adding-a-Todo-todo)
  - [Adding a Deadline: `deadline`](#Adding-a-Deadline-deadline)
  - [Adding an Event: `event`](#Adding-an-Event-event)
  - [List all tasks: `list`](#List-all-tasks-list)
  - [Mark a task: `mark`](#Mark-a-task-mark)
  - [Unmark a task: `unmark`](#Unmark-a-task-unmark)
  - [Find tasks by keyword: `find`](#Find-tasks-by-keyword-find)
  - [Delete a task: `delete`](#Delete-a-task-delete)
  - [Exiting the program: `bye`](#Exiting-the-program-bye)
  - [Saving the data](#Saving-the-data)
  - [Editing the data file](#Editing-the-data-file)

## Features

### Adding a Todo: `todo`
Adds a task of Todo type.

Format: `todo DESCRIPTION`

Example: `todo complete tutorial`


### Adding a Deadline: `deadline`
Adds a task of Deadline type.

Format: `deadline DESCRIPTION /by BY`

- `BY` must be provided.

Example: `deadline complete assignment /by Friday`


### Adding an Event: `event`
Adds a task of Event type.

Format: `event DESCRIPTION /from FROM /to TO`

- Both `FROM` and `TO` must be provided.

Example: `event band practice /from 2pm /to 3pm`


### List all tasks: `list`
Shows a lists of all tasks stored.

Format: `list`

### Mark a task: `mark`
Mark a task as completed.

Format: `mark INDEX`

- Marks the task at the specified `INDEX`. The index refers to
the number shown in `list`.

Example: `mark 5`

### Unmark a task: `unmark`
Unmark a task.

Format: `unmark INDEX`

- Unmarks the task at the specified `INDEX`. The index refers to
the number shown in `list`.

Example: `unmark 2`


### Find tasks by keyword: `find`
Find tasks that contain a given keyword.

Format: `find KEYWORD`

- If a phrase is passed, the entire phrase is searched.

Example: `find homework`


### Delete a task: `delete`
Deletes the specified task.

Format: `delete INDEX`

- Deletes the task at the specified `INDEX`. The index refers to
the number shown in `list`.

Example: `delete 1`


### Exiting the program: `bye`
Exits the program.

Format: `bye`


### Saving the data
Wallybot's data is saved in the hard disk automatically after
any command that changes the data, removing the need to save manually.


### Editing the data file
Wallybot's data is saved automatically as a txt file 
`[user]/Documents/wallybot_data.txt`.

> [!CAUTION]
> Any changes that invalidate the data format will lead to
> incomplete data being read. Edits may also cause Wallybot to
> behave unexpectedly.
> 
> It is recommended to make a backup
> before editing.
