package Sorting;

import java.util.Arrays;

/*
 * Count of Smaller Numbers After Self
 * Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].



Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 */
public class CountSelf {
    static int[] solve(int[]  nums){
        int n = nums.length;
        int[] count = new int[n];
        int[] indexes = new int[n];
        for(int i=0;i<n;i++){
            indexes[i]=i;
        }
        mergesort(nums,indexes,count,0,n-1);
        return count;
    }    
    public static void mergesort(int[] nums, int[] indexes, int[] count, int left, int right){
        if(left>=right) return;
        int mid=left+(right-left)/2;
        mergesort(nums,indexes,count,left,mid);
        mergesort(nums,indexes,count,mid+1,right);
        merge(nums, indexes,count,left,mid,right);
    }
    public static void merge(int[] nums, int[] indexes, int[] count, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i=left, j=mid+1, k=0;
        int rightCount=0;
        while(i<=mid && j<=right){
            if(nums[indexes[j]] < nums[indexes[i]]){
                temp[k++]=indexes[j++];
                rightCount++;
            }else{
                count[indexes[i]]+=rightCount;
                temp[k++]=indexes[i++];
            }
        }
        while(i<=mid){
            count[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }
        while(j<=right){
            temp[k++]=indexes[j++];
        }
        for(int p = 0; p<temp.length; p++){
            indexes[left+p] = temp[p];
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(Arrays.toString(solve(nums)));
    }
}
