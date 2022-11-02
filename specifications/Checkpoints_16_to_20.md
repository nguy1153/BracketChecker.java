# Practical 4

## Weeks 10 - 12 : Checkpoints 16 - 20

# Submission Date

Practical 4 checkpoints are due at the end of your practical session in week 12.

## Getting Started

The practical will lead you through the creation of various classes to give you some insight into how **Stacks**
and **Queues** can be used to process data. The first part uses a Stack to solve the classic compiler problem of parsing
a string for the correct syntax of brackets. The second part uses a Queue, and a Priority Queue for ordering Wombats in
a veterinary clinic.

Note that checkpoints 16 - 18 can be done independently of checkpoints 19 - 20. That is, if you get stuck on checkpoint
18 you can move on checkpoint 19 as 19 does not build upon 18.

On FLO in the Assessment Hub you will find a "*Practical 4: Self-Review*" quiz that allows you to test for yourself the
completion of parts of the checkpoints 16, 17, and 19.

Run IntelliJ and create a project called `Practical04`.

**It is important that you fully read the instructions before you start to code!**

## Checkpoint 16

The task of parsing a file for correctness is an essential part of any programmer toolkit. to check for a balanced set
of brackets in a file, a Stack can be used, and the following algorithm implemented:

- The source file is read character by character
- Each time an opening '{' is read it is pushed onto the stack
- Each time a closing '}' is read the stack is popped
- If the stack is empty when a closing '}' is read then there must be a missing '{'
- If the stack is not empty at the end of the file then there must be a missing closing '}'

Create the following class.

1. `BracketChecker` - this class contains:
    1. a single `private` instance variable `stack` of type
       `Stack<Character>` which is initialised it to new `Stack<>()`
    2. a single method `check` that takes a single formal parameter of type `String` and returns a `boolean`, i.e.
        ```java
       public boolean check(String text) {
            return false; 
       }
       ```
2. Modify the main method of `BracketTester` so that it:
    1. Prints the message "Starting Bracket Checker application"
    2. Defines a variable called `checker` of type `BracketChecker`, initialised to a new
       `BracketChecker` object.
    3. Defines a variable called `in` of type `Scanner`, initialised to new `Scanner(
       System.in)`. This will allow input from the keyboard.
    4. Calls `in.nextLine()` and passes the result to the `check` method of
       `checker`
    5. Prints the result of the method call.
        1. if it is true then "Syntax Correct"
        2. if it is false then "Syntax Error"

Run the project. The following output should be produced (example input, **{{}}** is shown in bold below):

<pre><code>
    Starting Bracket Checker application
    <b>{{}}</b>
    Syntax Error
</code></pre>

**NOTE:** this program will always print *Syntax Error* as the stub method `check`
always returns `false`

**Test your BracketChecker class code in the self-review quiz on FLO.**

1. Fully Implement the `check` method in `BracketChecker` so that it examines each character

   **Hint:** use `.charAt(int index)` in the `String` passed as a parameter<br><br>
    1. if it is an opening '{' push it onto the stack
    2. if it is a closing '}' and,
        1. the stack is empty, then return false
        2. else pop the stack, .pop()
    3. any other character is ignored (not pushed onto the stack)
    4. when the end of the string is reached
        1. if the stack is empty, then return true
        2. if the stack is not empty, then return false<br><br>
2. Add a `while` loop to main method in `BracketTester.java` so that multiple lines can entered for checking<br><br>
3. Add a print statement at the end stating `Exiting Checker`<br><br>
4. Run the application. The following output should be produced (example input is indicated in **bold**):

    <pre><code> Starting Bracket Checker application
    <b>{{}}</b>
    Syntax Correct
    <b>{{}</b>
    Syntax Error
    <b>{"Hello{}World"}</b>
    Syntax Correct<br>
    Exiting Checker
    </code></pre>

**Test your BracketChecker class code in the self-review quiz on FLO.**

## Checkpoint 17

Most programs that process data will read from a file and not from the keyboard to check hundreds, thousands, or even
more lines. This checkpoint changes the main method to read from a file.

1. Change the constructor of the `Scanner` object in the `main` method to use the
   `File` version
   ```java
   String filePath = "brackets01.txt"; 
   Scanner in = new Scanner(new FileReader(filePath));
   ```
2. This should create an error in your code about not handling the `FileNotFoundException`. Add a `
   throws`
   clause to your `main` method definition.
3. If you execute this code now (go on, do it) you will most likely receive the following error:
   <pre><code>
   <span style="color:red">Exception in thread "main" java.io.FileNotFoundException: brackets01.txt (The system cannot find the file specified)</span>
   </code></pre>
   This means your program cannot find the `brackets01.txt` file. To fix this problem,
    1. You need to include the correct path to `brackets01.txt`.
    2. The file is contained in the "resources" folder of the current Checkpoint
    3. Type in the correct path for `brackets01.txt`<br>
       **Hint:**
       Go to the BracketTester Run configuration and check that the working directory is set to the `
       resources` directory i.e. the Working directory path should be:
       `<wherever you saved the project>\Practical 3\Part A\BracketTester\resources`

       Execute your program again. Your program should not throw the same exception. If it does ask your demonstrator
       for assistance.<br><br>
4. Add a print statement in your main method to print each line that is about to be processed by the
   `check` method<br><br>
5. The last line in `brackets01.txt` is an empty line so your program should work in a similar way as it does to the
   keyboard input method. It should produce the following output in response to the input file:
   <pre><code>{}{} 
   Syntax Correct 
   {{}} 
   Syntax Correct 
   {}} 
   Syntax Error 
   {} Syntax Correct 
   Exiting Checker</code></pre>
   if it does not then modify your code to correct any issues. For example you may need to modify your looping condition
   or how you check for the end of user input (end of file).<br><br>
6. Open the `brackets01.txt` file and add more lines for your `BracketChecker` to test your program further.

   **Hint:** Remember to keep at least one empty line as the last line in your file

A common way to process sequential data is to buffer it in a queue for subsequent processing. Also, it is good to know
that a syntax error occurred, but it would be more helpful to know where it occurred.

1. Add a queue declaration to your main method that contains objects of type `String`. You can choose which queue
   implementation to use (e.g. `ArrayDeque`, `LinkedList`)<br><br>
2. Read each line from the file and store it in the newly declared queue (using the `offer` method)<br><br>
3. Process each item in the queue using the `poll` method and calling the `check` method of your BracketChecker
   variable. You should now have two loops - one to read in and buffer the data, and another to process the data in the
   buffer. Your program should produce the same output at the previous checkpoint.

   **Hint:** You will need to change the condition in the original while loop to process the data in the buffer not the
   file as before.

To report where the error occurred your `BracketChecker` class will need to store the index of the character where the
error occurred so that it can be retrieved in the event of an error.

1. Add a private instance variable of type `int` in the `BracketChecker` class called `position`.<br><br>
2. Add a getter method for this new instance variable<br><br>
3. In the `check` method where you decided that an error has occurred (e.g. you return false) assign the current index
   into the string to the `position` instance variable.<br><br>
4. When a syntax error is found in the main method by a call to `check`, report the error and indicate the `position`.
   Call this code after printing the line, e.g.
   ```java
   ... 
   BracketChecker checker = new BracketChecker(); 
   boolean isCorrect = checker.check(line); 
   ... 
   for (int i = 0; i < checker.getPosition(); i++) { 
    System.out.print(" "); 
   } 
   System.out.println("|"); 
   System.out.println("Syntax Error at position " + checker.getPosition());
   ```
5. Run the application. The output below should be produced if the original `brackets01.txt`. Add more lines to the text
   file to test your program

<pre><code>    Starting Bracket Checker application
    {}{}
    Syntax Correct
    {{}}
    Syntax Correct
    {}}
      |
    Syntax Error at position 2
    {}
    Syntax Correct
    Exiting Checker
</code></pre>

Test your BracketChecker class code in the self-review quiz on FLO and convince a tutor that your application is
correct.

## Checkpoint 18

<span style="color: red">**Caution: Tricky!**</span>

To make the BracketChecker class more general we can check for more than just '{' and '}'

1. Modify the BracketChecker class to include the following
    1. add an instance variable to store the opening bracket types, an array of char's

       `char[] opening`
    2. add an instance variable to store the closing bracket types, an array of char's

       `char[] closing`
    3. add a constructor that sets the values of `opening` and `closing` (e.g. right-click <kbd>"
       Generate..."</kbd> or <kbd>"Alt + Insert"</kbd> on a Windows machine)
    4. add a private method to check if a character is an opening character, use the code below
         ```java
         /**
         * Determine if the parameter 'in' is in the opening array and returns
         * the position if found.
         *
         * @param in the character to check
         * @return the position in the array if found, -1 otherwise
         */
           private int isOpening(char in) {
             for (int ci = 0; ci < opening.length; ci++) {
                 if (in == opening[ci]) {
                 return ci;
                 }
             }
           return -1; // character not found
           }
         ```
    5. add a private method to check if a character is a closing character copy-and-paste/reuse the `
       isOpening` code
    6. use the `isOpening` and `isClosing` methods in the check method to see if the current character is an opening or
       closing bracket (e.g. `isOpening` returns a value > -1)
    7. to determine if there is a correct bracket sequence you need to check the top of stack (using `
       .peek()`) to see if a current closing bracket matches the top of the stack. For example,
         ```java
         int cli = isClosing(line.charAt(c));
         char top = s.peek();
         if (top != opening[cli]) {
         // ERROR, not matching brackets
         }
       ```
2. Add to the main method two variables that represent the opening and closing brackets sets, e.g.

    ```java
    char[] opening = {'{','(', '['};
    char[] closing = {'}',')', ']'};
    ```

Pass these new variables to the new `BracketChecker` constructor, e.g.
`BracketChecker bc = new BracketChecker(opening, closing);`

3. Download `brackets02.txt` from FLO, put it in the resources folder, and change the `filePath`
   to use this new file. Run the application. The below output should be produced.
    ```
    {}{} 
    Syntax Correct 
    {{()}} 
    Syntax Correct 
    {}} | 
    Syntax Error at position 2 
    {} 
    Syntax Correct
    ({})
    Syntax Correct 
    {)
    | Syntax Error at position 1 
    Exiting Checker
    ```
4. Add more bracket combinations and more lines to the file to test out your application. The file `
   brackets03.txt`, available on FLO, contains '{', '(' and '[' combinations for `opening` and `
   closing`.

## Checkpoint 19

These last two checkpoints use the queue data structure to assist in ordering Wombat in a veterinary clinic. Checkpoint
19 processes Wombats in a traditional first come, first served basis (FIFO, in terms of programmatic insertion).

1. Create a new class called `Wombat`
    1. add an `String` instance variable `name` to store the name of the Wombat
    2. add an `int` instance variable `severity` to store the severity of the injuries for the Wombat (1 - least severe,
       10 - most severe)
    3. add a `double` instance variable `time` to store the time of arrival (in fractional hours of the day) of the
       Wombat
    4. add a constructor that sets all three instance variables, with the order of the formal parameters of name,
       severity, and time.
    5. add getter and setters
    6. add an appropriate `toString` method with the format "`name, severity, time`"
2. Modify the main method in `WombatDriver` to include the following code
    ```java
    Queue<Wombat> wombatQueue = new ArrayDeque<Wombat>();
   
    wombatQueue.add(new Wombat("Fluffy",5,10.5));
    wombatQueue.add(new Wombat("Socks",10,11.3));
    wombatQueue.add(new Wombat("Barry",10,10.8));
    wombatQueue.add(new Wombat("Jobe",3,12.0));
    wombatQueue.add(new Wombat("Ginger",15,3.2));
   
    System.out.println(wombatQueue);
    ```
4. Use a loop to `poll` each Wombat from the queue and print their details. The output should be as follows:
    ```
    Fluffy, 5, 10.5
    Socks, 10, 11.3
    Barry, 10, 10.8
    Jobe, 3, 12.0
    Ginger, 15, 3.2
    ```

**Test your Wombat class code in the self-review quiz on FLO.**

A veterinary clinic may want to process its current `Wombat` queue in the order of severity, i.e. more severe Wombats (
higher `severity` value) are processed first. A `PriorityQueue` can be used to automatically sort the queue based on the
priority of severity.

1. Change the implementation of the `wombatQueue` variable to be a `PriorityQueue`. Run you code. You should get an
   error in the output window similar to:

<pre><code><span style="color: red">
Exception in thread "main" java.lang.ClassCastException: practical03vets.Wombat cannot be cast to java.lang.Comparable
    at java.base/java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:642)
    at java.base/java.util.PriorityQueue.siftUp(PriorityQueue.java:638)
    at java.base/java.util.PriorityQueue.offer(PriorityQueue.java:329)
    at java.base/java.util.PriorityQueue.add(PriorityQueue.java:310)
    at WombatDriver.main(WombatDriver.java:11)
Java Result: 1
</span></code></pre>

This error means that `Wombat` does not implement the `Comparable` interface

2. Make your Wombat class implement the `Comparable` interface, that is
   `public class Wombat implements Comparable<Wombat>`
   Implement all abstract methods. Implement the `compareTo` so that the `Wombat` with the highest `severity` is given
   the highest priority (polled from the queue first).
3. Your program should output something similar to below with the original set of Wombats. Add more Wombats to your
   Wombat queue to test out the ordering of the priority queue
    ```
    Ginger, 15, 3.2 
    Socks, 10, 11.3 
    Barry, 10, 10.8 
    Fluffy, 5, 10.5 
    Jobe, 3, 12.0
    ```

## Checkpoint 20

1. Wombats that have the same severity level are grouped together and are retrieved from the queue in any order
   (from the API: "ties are broken arbitrarily"). Wombats with the same `severity` should order so that the Wombat with
   the earliest `time` should have a higher priority. Modify the `compareTo` method to operate in this way. The output
   from the original set of Wombats should now be (note the order of Barry and Socks):
    ```
    Ginger, 15, 3.2
    Barry, 10, 10.8
    Socks, 10, 11.3
    Fluffy, 5, 10.5
    Jobe, 3, 12.0
    ```
2. Some Wombats, such as Ginger, may try to jump the queue by have a severity higher than the maximum of 10. To counter
   this, create a new exception that is raised when an out of bounds severity is detected.
    1. create a new class that extends the `Exception` class called `SeverityOutOfBoundsException`
    2. in the Wombat constructor check the that the value of `severity` is greater than 0 and less than 11, that is in
       the range [1 10]
    3. if `severity` is out of bounds throw an instance of your newly created exception class
    4. add the necessary `throws` clauses to your methods
    5. If you still have Ginger in your list of Wombats you should receive an exception similar to the following
       <pre><code><span style="color: red;">
       Exception in thread "main" SeverityOutOfBoundsException: Severity is not within 1-10 at Wombat.<init>(Wombat.java:12)
       at WombatDriver.main(WombatDriver.java:15)<br>
       Process finished with exit code 1
       </span></code></pre>
3. To make the application more usable get Wombat data from the user via the keyboard.
    1. add a `Scanner` object to read from the keyboard (`System.in`)
    2. keep reading from the keyboard until the user enters `QUIT`
    3. use another `Scanner` object to extract the `name`, `severity`, and
       `time` from each line entered

       **Hint:** use `.next()`, `.nextInt()`, and `.nextDouble()`

    4. if the users enters `PROCESS` then the queue should be processed/emptied.
    5. add a `try-catch` your `main` method to catch the out of bounds exception. Print an informative message and
       continue accepting user input. Example output is shown below. User Input in **bold**
    <pre><code> <b>Sweeps 4 10.3
    Fluffy 9 11.3
    Socks 9 10.3
    Ginger 15 4.5</b>
    Severity it not within 1-10
    <b>PROCESS</b>
    Socks, 9, 10.3
    Fluffy, 9, 11.3
    Sweeps, 4, 10.3
    <b>QUIT</b>
    </code></pre>