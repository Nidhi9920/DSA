package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    public void push(int x){
        q2.add(x);
        if(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1=q2;
        q2=temp;
    }
    public int pop(){
        return q1.poll();
    }
    public int top(){
        return q1.peek();
    }
    public boolean isEmpty(){
        return q1.isEmpty();
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
