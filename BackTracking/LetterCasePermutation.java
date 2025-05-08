package BackTracking;

import java.util.ArrayList;
import java.util.List;
/*Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"] */
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(),0,result);
        return result;
    }
    public static void backtrack(char[] characters,int index, List<String> result){
        if(index==characters.length){
            result.add(new String(characters));
            return;
        }
        backtrack(characters,index+1,result);
        if(Character.isLetter(characters[index])){
            characters[index]^=32; // Toggle case using bitwise XOR (fast trick)
            backtrack(characters,index+1,result);
            characters[index]^=32;
        }
    }
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }
}
