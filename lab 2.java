// Lab 2 - Lists, Stacks, and Queues
// Your Name: Oleh Bulchak
// Notes: The instructions are found in comments through the code starting with "Step n"
//        Please leave the comments and add your code just after the comment.
//        Use the examples in the book to complete the lab.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Lab2 lab = new Lab2();
    // Comment/Uncomment the following 3 method calls as you work on each method.
    // No code should be added to the main method. All of your code will go into the methods in Lab2.
    lab.linkedList();
    lab.queue();
    lab.stack();
  }
}

class Lab2 {
  public void linkedList() {
    // 1. Create a LinkedList<String> object called progLanguages
    LinkedList<String> progLanguages = new LinkedList<>();

    // 2. Add elements to progLanguages: "Java", "Python", "JavaScript", "C++"
    progLanguages.add("Java");
    progLanguages.add("Python");
    progLanguages.add("JavaScript");
    progLanguages.add("C++");

    // 3. Remove the element "C++" from the list using .remove()
    progLanguages.remove("C++");

    // 4. Add an element "HTML" at index 2.
    progLanguages.add(2, "HTML");

    // 5. Iterate over progLanguages and use println() to output each element. You must create an Iterator<string> and use hasNext(), and next() similar to the example in our book.
    
    Iterator<String> it = progLanguages.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
  
  public void queue() {
    // 6. Create a Queue<String> called q
    Queue<String> q = new LinkedList<>();

    // 7. Add 5 first names to q.
    q.add("Oleh");
    q.add("Viktor");
    q.add("Vasyl");
    q.add("Steph");
    q.add("Sonia");

    // 8. Uncomment the following line
    System.out.println("Elements of queue: " + q);

    // 9. Remove the head of the queue and assign it to a String variable removedElement
    //    Display the value of "Removed element: " + removedElement
    String removedElement = q.remove();
    System.out.println("Removed element: " + removedElement);

    // 10. View the head of the queue using peek(). Output its value
    System.out.println("Head of queue: " + q.peek());

    // 11. Using for(String element : q), output all of the values in the queue
    for (String element : q) {
      System.out.println(element);
    }
  }

  public void stack() {
    // 12. Create a Stack<String> called bookStack
    Stack<String> bookStack = new Stack<>();

    // 13. Push the following book titles onto bookStack: "Clean Code", "Design Patterns", "Pragmatic Programmer"
    bookStack.push("Clean Code");
    bookStack.push("Design Patterns");
    bookStack.push("Pragmatic Programmer");

    // 14. pop() 1 book off the stack. Display its value
    String poppedBook = bookStack.pop();
    System.out.println("Popped book: " + poppedBook);

    // 15. Use the peek() method to view the top book on the stack
    System.out.println("Top book: " + bookStack.peek());

    // 16. push() "Web DB Technologies" onto the stack
    bookStack.push("Web DB Technologies");

    // 17. Use the peek() method to view the top book on the stack
    System.out.println("Top book after push: " + bookStack.peek());

    // 18. Search for "Design Patterns" in the stack. Display the results of the search
    int position = bookStack.search("Design Patterns");
    System.out.println("Position of 'Design Patterns': " + position);

    // 19. Call empty(). Output the results
    System.out.println("Is stack empty? " + bookStack.empty());

    // 20. Print the titles of all of the books on the stack
    for (String book : bookStack) {
      System.out.println(book);
    }
  }
}