package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/*
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
 */
public class SlidingWindowMaximum {
    public static int[] slidingWindowMaximum(int[] nums, int k){
        if(nums==null || k<=0) return new int[0];
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            //remove index not in window
            while(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            //remove all indices whose element are less than current element and maintain decreasing order in deque
            while (!deque.isEmpty()&& nums[deque.peekLast()]< nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        System.out.println(Arrays.toString(slidingWindowMaximum(nums, k)));
    }
}
