package Queue;

import java.util.Stack;
/*
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
 */
public class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;
    public MyQueue(){
        input = new Stack<>();
        output = new Stack<>();
    }
    public void push(int x){
        input.push(x);
    }
    public int pop(){
        peek();
        return output.pop();
    }
    public int peek(){
        if(output.isEmpty()){
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    public boolean empty(){
        return input.isEmpty() && output.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("Front element: " + queue.peek());  // Output: 1
        System.out.println("Removed element: " + queue.pop()); // Output: 1
        System.out.println("Is queue empty? " + queue.empty()); // Output: false

        queue.push(4);
        System.out.println("Removed element: " + queue.pop()); // Output: 2
        System.out.println("Front element: " + queue.peek());  // Output: 3
    }
}
