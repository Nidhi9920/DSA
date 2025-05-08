package BackTracking;

import java.util.ArrayList;
import java.util.List;

/*Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]] */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),s,0);
        return res;
    }
    public static void backtrack(List<List<String>> res, List<String> tempList, String s, int start){
        if(start==s.length()){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int end=start+1;end<=s.length();end++){
            String substring = s.substring(start,end);
            if(isPalindrome(substring)){
                tempList.add(substring);
                backtrack(res,tempList,s,end);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String substring){
        int left=0,right=substring.length()-1;
        while(left<right){
            if(substring.charAt(left++)!=substring.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
