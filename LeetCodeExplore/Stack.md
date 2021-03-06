# Stack
## Last-in-first-out Data Structure
In a LIFO data structure, the newest element added to the queue will be processed first.
Different from the queue, the stack is a LIFO data structure. Typically, the insert operation is called push in a stack. Similar to the queue, a new element is always added at the end of the stack. However, the delete operation, pop, will always remove the last element which is opposite from the queue.
## Operations
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. Initialize a stack.
        Stack<Integer> s = new Stack<>();
        // 2. Push new element.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty.
        if (s.empty() == true) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        System.out.println("The top element is: " + s.peek());
        // 6. Get the size of the stack.
        System.out.println("The size is: " + s.size());
    }
}
```
## Conclusion: solving problems
1. When peek() or pop(), check isEmpty() in advance.
2. The key is to find the LAST IN FIRST OUT pattern.
3. What we push is various: not only the value, but also index, or something we think we need to use. It will not affect pop(), since we can pop this value and keep the order.
