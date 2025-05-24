package Stack;

import java.util.Stack;
/*
 * Given a string containing just the characters '(' and ')', return the length of the 
 * longest valid (well-formed) parentheses substring.
Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
 */
public class LongestValidParenthesis {
    public static int solve(String s){
        Stack<Integer> stack = new Stack<>();
        int maxLength=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxLength = Math.max(maxLength, i-stack.peek());
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "(()";
        System.out.println(solve(str));
    }
}
