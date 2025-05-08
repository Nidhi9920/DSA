package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. */

public class LetterCombination {
    public static final Map<Character,String> phoneMap = new HashMap<>();
    static{
        phoneMap.put('2',"abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null||digits.length()==0) return result;
        backtrack(digits, 0, new StringBuilder(),result);
        return result;
    }
    public static void backtrack(String digits, int index, StringBuilder path, List<String> result){
        if(index==digits.length()){
            result.add(path.toString());
            return;
        }
        String possibleLetters = phoneMap.get(digits.charAt(index));
        for(char letter : possibleLetters.toCharArray()){
            path.append(letter);
            backtrack(digits,index+1,path,result);
            path.deleteCharAt(path.length()-1);
        } 
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
