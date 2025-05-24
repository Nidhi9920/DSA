package Stack;

import java.util.Stack;
/*
 * Given a string s, remove duplicate letters so that every letter appears once and 
 * only once. You must make sure your result is the smallest in lexicographical order 
 * among all possible results.
Example 1:

Input: s = "bcabc"
Output: "abc"

 */
public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            freq[c-'a']--;
            if(inStack[c-'a']) continue;
            while(!stack.empty()&& stack.peek()>c && freq[stack.peek()-'a']>0){
                inStack[stack.pop()-'a']=false;
            }
            stack.push(c);
            inStack[c-'a']=true;
        }
        StringBuilder result = new StringBuilder();
        for(char c : stack){
            result.append(c);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str = "bcabc";
        System.out.println(removeDuplicateLetters(str));
    }
}
