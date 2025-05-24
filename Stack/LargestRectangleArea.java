package Stack;

import java.util.Stack;
/*
 * Given an array of integers heights representing the histogram's bar height where 
 * the width of each bar is 1, return the area of the largest rectangle in the 
 * histogram.
Input: heights = [2,1,5,6,2,3]
Output: 10

 */
public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights){
        int maxArea=0;
        int n=heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<=n; i++){
            int currHeight = (i==n) ? 0 : heights[i];
            while(!stack.empty() && currHeight<heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h*w);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
