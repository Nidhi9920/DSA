package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k,n,1,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int k, int n, int index, List<Integer> numList, List<List<Integer>> result){
        if(k==0 && n==0){
            result.add(new ArrayList<>(numList));
            return;
        }
        if(k==0||n<0) return;
        for(int i=index;i<=9;i++){
            numList.add(i);
            backtrack(k-1,n-i,i+1,numList,result);
            numList.remove(numList.size()-1);
        }
    }
    public static void main(String[] args) {
        int k=3,n=7;
        System.out.println(combinationSum3(k, n));
    }
}
