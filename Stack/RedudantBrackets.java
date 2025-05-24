package Stack;

import java.util.Stack;
/*
 * Given a string of balanced expressions, find if it contains a redundant parenthesis
 * or not. A set of parenthesis is redundant if the same sub-expression is surrounded 
 * by unnecessary or multiple brackets. Return true if redundant, else false.
Input: str = “((a+b))”
Output: true
Explanation: ((a+b)) can reduced to (a+b), this Redundant

 */
public class RedudantBrackets {
    public static boolean solve(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c==')'){
                boolean hasOperator=false;
                while(!stack.empty() && stack.peek()!='('){
                    char top = stack.pop();
                    if(top=='+'||top=='-'||top=='*'||top=='/'){
                        hasOperator=true;
                    }
                }
                if(!stack.empty() && stack.peek()=='('){
                    stack.pop();
                }
                if(!hasOperator){
                    return true;
                }
            }else{
                stack.push(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "((a+b))";
        System.out.println(solve(s));
    }
}
