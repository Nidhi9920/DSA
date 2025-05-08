package BackTracking;
/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
import java.util.*;
public class Permutation2 {
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(), used,res);
        return res;
    }
    public static void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> res){
        if(current.size()==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            current.add(nums[i]);
            used[i]=true;
            backtrack(nums, current, used, res);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
