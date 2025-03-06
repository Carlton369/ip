# Snorlax User Guide

Snorlax is a task management application that helps you keep track of your tasks. You can add, delete, mark, unmark, find, and list tasks. You can also search if there are any Tasks on a certain date. Tasks can be of three types: Todo, Deadline, and Event.

## Features

### Adding a Todo Task

Adds a todo task to the list.

**Usage:**
```
todo TASK_DESCRIPTION
```

**Example:**
```
todo read book
```

**Expected Output:**
```
Ok..... I have added this "todo" task.....
[T][ ] read book
You now have X tasks in the list...
```

### Adding a Deadline Task

Adds a deadline task to the list.

**Usage:**
```
deadline TASK_DESCRIPTION /by DATE(yyyy-MM-dd)
```

**Example:**
```
deadline return book /by 2023-12-31
```

**Expected Output:**
```
Ok..... I have added this "deadline" task.....
[D][ ] return book (by: 31-DECEMBER-2023)
You now have X tasks in the list...
```

### Adding an Event Task

Adds an event task to the list.

**Usage:**
```
event TASK_DESCRIPTION /from START_DATE(yyyy-MM-dd) /to END_DATE(yyyy-MM-dd)
```

**Example:**
```
event project meeting /from 2023-12-01 /to 2023-12-02
```

**Expected Output:**
```
Ok..... I have added this "event" task.....
[E][ ] project meeting (from: 1-DECEMBER-2023 to: 2-DECEMBER-2023)
You now have X tasks in the list...
```

### Listing All Tasks

Lists all tasks in the list.

**Usage:**
```
list
```

**Expected Output:**
```
Here are the tasks in the list:
1. [T][ ] read book
2. [D][ ] return book (by: 31-DECEMBER-2023)
3. [E][ ] project meeting (from: 1-DECEMBER-2023 to: 2-DECEMBER-2023)
```

### Marking a Task as Done

Marks a task as done.

**Usage:**
```
mark TASK_NUMBER
```

**Example:**
```
mark 1
```

**Expected Output:**
```
Ok..... I will mark this task as done.....
[T][X] read book
```

### Unmarking a Task

Unmarks a task as not done.

**Usage:**
```
unmark TASK_NUMBER
```

**Example:**
```
unmark 1
```

**Expected Output:**
```
Ok..... I will mark this task as not done yet.....
[T][ ] read book
```

### Deleting a Task

Deletes a task from the list.

**Usage:**
```
delete TASK_NUMBER
```

**Example:**
```
delete 1
```

**Expected Output:**
```
Ok..... I will delete this task.....
[T][ ] read book
```

### Finding Tasks

Finds tasks that contain a specific keyword.

**Usage:**
```
find KEYWORD
```

**Example:**
```
find book
```

**Expected Output:**
```
Here are the related tasks:.....
[T][ ] read book
[D][ ] return book (by: 31-DECEMBER-2023)
```

### Checking Tasks on a Specific Date

Lists tasks that are due or happening on a specific date.

**Usage:**
```
on DATE
```

**Example:**
```
on 2023-12-31
```

**Expected Output:**
```
Here's what's going on.....
[D][ ] return book (by: 31-DECEMBER-2023)
```

### Exiting the Application

Exits the application.

**Usage:**
```
bye
```

**Expected Output:**
```
Bye..... see you soon....
```