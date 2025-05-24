package Sorting;
/*
 * Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 */
class reversePairs{
    static int solve(int[]  nums){
        if(nums==null||nums.length==0) return 0;
        return mergesort(nums,0,nums.length-1);
    }
    public static int mergesort(int[] nums, int left, int right){
        if(left>=right) return 0;
        int mid = left+(right-left)/2;
        int count = mergesort(nums,left,mid)+mergesort(nums,mid+1,right);
        int j=mid+1;
        for(int i=left;i<=mid;i++){
            while(j<=right && (long)nums[i]>2L*nums[j]){
                j++;
            }
            count += j-(mid+1);
        }
        merge(nums,left,mid,right);
        return count;
    }
    public static void merge(int[] nums, int left, int mid, int right){
        int[] temp=new int[right-left+1];
        int i=left,j=right, k=0;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=right) temp[k++]=nums[j++];
        System.arraycopy(temp,0,nums,left,temp.length);
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(solve(nums));
    }
}