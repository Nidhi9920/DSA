package BackTracking;
import java.util.*;
/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

 */
class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }
    public static void backtrack(List<String> result, String current, int open, int close, int n){
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        if(open<n){
            backtrack(result,current+"(",open+1,close,n);
        }
        if(close<open){
            backtrack(result,current+")",open,close+1,n);
        }
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}