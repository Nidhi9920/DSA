package Stack;

import java.util.Arrays;
import java.util.Stack;
/*
 * Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days you have
 *  to wait after the ith day to get a warmer temperature. If there is no 
 * future day for which this is possible, keep answer[i] == 0 instead.
Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperature {
    public static int[] dailyTemperature(int[] temperatures){
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.empty()&&temperatures[i]>temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperature(temperatures)));
    }
}
