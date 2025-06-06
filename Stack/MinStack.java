package Stack;
import java.util.Stack;
/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    public MinStack(){
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    public void push(int val){
        stack.push(val);
        if(minstack.empty() || val<=minstack.peek()) minstack.push(val);
    }
    public void pop(){
        int popped=stack.pop();
        if(popped==minstack.peek()) minstack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minstack.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
