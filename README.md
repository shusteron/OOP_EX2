# OOP_EX2
Third assignment in "Object-Oriented Programming" course at Ariel University.

## Description
This assignment focuses on the use of threads and thread pools.<br>
The assignment is divided into two parts:
- Part 1: Threads with Files. In this part of the assignment,we were required to utilize threads to process files.
- Part 2: Asynchronous Tasks with Priority. In this part of the assignment, we were required to create a new object that represents an asynchronous task,
  with priority levels. In addition, we were needed to create a Threadpool that can handle tasks of this type, and execute them in accordance with their assigned   
  priority levels.
 
# First part: Ex2_1
In this part of assigment we were asked to make some text files and calculate all of their lines and measure time using three methods: <br>
 1. Regular, without any threads. <br>
 2. Using Threads. <br>
 3. Using TheardPool. <br>
 
 ## ThreadFile
 Extends the `Thread` class. A thread in Java is the direction or path that is taken while a program is being executed. 
 
 myThread has 2 private variables:
 - `String file`
 - `int lines`
 
 in addition, `ThreadFile` has the following methods:<br>
 - `ThreadFile`
 - `getLines()`
 - `run()`
 
 
 #### `ThreadFile(String file)`
 Assigns the name of the file, and creates thread with that name.
 
 #### `getLines()`
 Returns the variable `lines`.
 
 #### `run()`
 Executing the thread.<br>
 Run calculating the number of lines with the exact file name given in the constractor <br>
 and initializing the variable `lines` to the method result.
 
 ***
 ## CallLines
 Implements the Callable interface. A task that returns a result and may throw an exception. Implementors define a single method with no arguments called call.<br>
 
  CallLines has 2 private variables:
 - `String file`
 
 in addition, `CallLines` has the following methods:<br>
 - `CallLines`
 - `call()`

 #### `CallLines(String file)`
 Assigns the name of the file, and creates thread with that name .
 
 #### `calcLines()`
 A private method for calculating the number of lines with the exact file name given in the constractor <br>
 and initializing the variable `lines` to the method result.
 
 #### `call()`
 calculating the number of lines with the exact file name given in the constractor <br>
 and returns number of lines of the file.
 
 ### uml
 ![ex1_uml](https://user-images.githubusercontent.com/119599940/211843277-5caa8825-379a-4fca-8143-b4904ad55760.png)

### time calculation
we were used 3 diffrent ways, to calculte the amount of lines in 10,000 files.
- Method 1: Linear Time Calculation<br>

   - In this method, we employed a straightforward approach to calculate the number of lines in each of the 10,000 files. The process involves iterating through each 
   file and counting the number of lines in each file individually. The line count for each file is then recorded and stored. This method has a linear time complexity 
   of O(n), where n represents the number of files. While it is easy to implement, it is not the most efficient method as it does not account for the possibility of  p
   arallelization or optimization opportunities.
   It's worth noting that, real-world performance will vary based on several factors such as the type of file system and access method used, disk I/O operation and so 
   on. Therefore, this calculation is only considered as a rough estimate of time complexity of this method.

- Method 2: Multi-threaded Calculation

  - In this method, we utilized multi-threading to calculate the number of lines in each of the 10,000 files. For each file, we created a separate thread, with each 
  thread being responsible for counting the number of lines in one file. This method is more effective than the linear way, as all the threads are able to work in an 
  almost parallel manner. This approach allows for concurrent execution of multiple threads, reducing the overall processing time. However, the actual performance 
  improvement will depend on the system resources, such as the number of CPU cores, and the operating system's ability to schedule threads efficiently.
  
- Method 3: Thread Pool Calculation

  - In this method, we utilized a thread pool to calculate the number of lines in each of the 10,000 files. We created a thread pool with a fixed size equal to the 
  number of files, where each thread counted the lines of one file. This method improved performance over the linear method by utilizing a fixed number of threads and 
  efficiently using system resources. However, actual performance may not be as good as the multi-threaded method, depending on the resources of the system. 

### conclusions: 
- Based on the three methods described for calculating the number of lines in 10,000 files, we can conclude the following:
  - Method 1 is straightforward but not efficient.
  - Method 2 utilizes multi-threading to achieve almost parallel execution.
  - Method 3 utilizes a thread pool and improves over linear method but may not perform as well as method 2.

as we can see in the example image:<br>

![createfile](https://user-images.githubusercontent.com/119599940/211847818-ec276700-85c2-48ee-9726-3e862e62b59e.png)

## The second part – Ex2_2:
In this part of the assigment we had to create a new task type that can be used in a ThreadPool,<br>
where tasks have a priority level and are executed accordingly by the ThreadPool. This would allow for prioritized task execution,<br>
where tasks with higher priority are executed first. <br>

- Our goal is to create two new types that extend the functionality of Java's Concurrency Framework
  - A generic task with a Type that returns a result and may throw an exception.
    Each task has a priority used for scheduling inferred from the integer value of the task's Type.

  - A custom thread pool class that defines a method for submitting a generic task as described in
    the section 1 to a priority queue, and a method for submitting a generic task created by a
    Callable<V> and a Type, passed as arguments. 

## Task<T>
 
this class is implements `Callable<T>` , `Comparable<Task<T>>`.
Task<T> has 2 private variables:
-  `TaskType taskType`
- `Callable <T> task`
 
 in addition, `Task<T>` has the following methods:<br>
 - `Task(Callable<T> task)`
 - `Task(Callable<T> task , TaskType taskType)`
 - `getTaskType()`
 - `getTask()`
 - `setTaskType(TaskType taskType)`
 - `setTask(Callable<T> task)`
 - `call()`
 - `compareTo(Task<T> otherTask)`
 - `equals(Object o)`
 - `hashCode()`
 - `toString()`
 
 furthermore, `Task<T>` has the following static methods:<br>
 - `Task createTask(Callable callable, TaskType taskType)`
 - `Task createTask(Callable callable)`
 
 ### Task(Callable<T> task)

  A private constructor, receive Callable<T> task

 ### Task(Callable<T> task , TaskType taskType)

  A private constructor;
  receive Callable<T> task , 
  enum TaskType, represent priority.

 ### Task createTask(Callable callable, TaskType taskType)

  This method create a new Task and return a new Task.


 ### Task createTask(Callable callable)

  This method create a new Task and return a new Task.

 ### getTaskType()

  Return the current TaskType.
  
 ### getTask()

  Return the Callable task.

 ### setTaskType(TaskType taskType)

  This method set the TaskType.

 ### setTask(Callable<T> task)

  This method set the task.

 ### call()

  This method Computes a result, or throws an exception if unable to do so.
  This method return computed result, and throws Exception – if unable to compute a result.

 ### compareTo(Task<T> otherTask)

  This function return 1 / -1 / 0 depends on if this taskType is larger smaller or even
  to the object to be compared.

 ### equals(Object o)

  This method check if 2 object are contain the same task and taskType.
  The method return true if they are equals, else false.

 ### hashCode()

  Generates a hash code for the object.
  The method return a hash value.

 ### toString()

  Returns a string representation of the object.
 
  ***
 
 ## AdapterCall
 This class extends the `FutureTask<T>` class and impliments the `Comparable<AdapterCall<T>>` interface. <br>
 The class goal is to make a bridge between `Runnable` to `Callable`. <br>
 
 AdapterCall has a private variable:
 - `int p` that will hold the task's priorety.<br>

In addition, `AdapterCall` has the following methods:<br>
- `AdapterCall(Callable<T> callable , int p)`
- `int getP()`
- `void setP(int p)`
- `int compareTo(AdapterCall<T> other)`
- `boolean equals(Object other)`
- `int hashCode()`
- `String toString()`

#### `AdapterCall(Callable<T> callable , int p)`
The constactor, a public method that assignes the `callable` and the `p` variables.<br>

#### `int getP()`
This method returns `p`, who stands for the task priority.

#### `void SetP(int p)`
This method initializing the variable `p`. 

#### `int compareTo(AdapterCall<T> other)`
This method compering between two variables from type-class `AdapterCall<T>`. <br>
The method calls to `Integer.compare(this.p , other.p)` that returns 1 / -1 / 0 , depends if `this.p` is greater, smaller, or even to `other.p`.

#### `boolean equals(Object other)`
This method indicates whether some other object is "equal to" this one.

#### `int hashCode()`
This method generates a hash code for the object.

#### `String toString()`
This method returns a string representation of the object.

***

## TaskType
An attached file we recieved from the assigment. <br>
Represents the task priority (int value), ranging 1 to 3, when 1 is most improtant. <br>
Class methods: <br>
- `setPriority(int priority)`
- `int getPriorityValue()`
- `TaskType getType()`
- `boolean validatePriority(int priority)`

***

## CustomExecutor
 
this class is extends from `ThreadPoolExecutor`.

CustomExecutor has 2 private variables:
- `int[] max`
- `final int maxp`
 
 in addition, `CustomExecutor` has the following methods:<br>
 - `CustomExecutor()`
 - `submit(Task<T> task)`
 - `submit(Callable<T> task , TaskType taskType)`
 - `submit(Callable<T> task)`
 - `beforeExecute(Thread t, Runnable r)`
 - `getCurrentMax()`
 - `gracefullyTerminate()`
 - `setCorePoolSize(int corePoolSize)`
 - `getCorePoolSize()`
 - `setMaximumPoolSize(int maximumPoolSize)`
 - `getMaximumPoolSize()`
 - `hashCode()`
 - `toString()`

 #### CustomExecutor()

  A constructor.

 #### submit(Task<T> task)

Submits a value-returning Task for execution and returns a Future representing the pending results of the task.
The return a Future representing pending completion of the task.

#### submit(Callable<T> task , TaskType taskType)

  Submits a value-returning task for execution and returns a Future representing the pending results of the task.
  The method return a Future representing pending completion of the task.


#### submit(Callable<T> task)

 Submits a value-returning task for execution and returns a Future representing the pending results of the task.
 the method return a Future representing pending completion of the task.

#### beforeExecute(Thread t, Runnable r)

This method activate before a task execute.

#### getCurrentMax()

Return the max priority in queue/

#### gracefullyTerminate()

 Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
 Invocation has no additional effect if already shut down.

#### setCorePoolSize(int corePoolSize)

 Sets the core number of threads.

#### getCorePoolSize()

Returns the core number of threads

#### setMaximumPoolSize(int maximumPoolSize)

 Sets the maximum allowed number of threads.

#### `int getMaximumPoolSize()`
this method returns the maximum allowed number of threads.

#### `int hashCode()`
This method returns a hash code value for the object.


#### `String toString()`
This method returns a string identifying this pool.
 
 ### uml
![ex2_uml](https://user-images.githubusercontent.com/119599940/211871525-f0a5986c-70f6-4e90-87de-2e87db21aac2.png)
 
 
 
 
