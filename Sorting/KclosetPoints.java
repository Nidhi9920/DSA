package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)^2 + (y1 - y2)^2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).



Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]] Explanation: The distance between (1, 3) and the origin is sqrt(10). The distance between (-2, 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin. We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

 */
public class KclosetPoints {
    public static List<List<Integer>> solve(List<List<Integer>>  points, int k){
        int[][] arr = new int[points.size()][2];
        for (int i = 0; i < points.size(); i++) {
            arr[i][0] = points.get(i).get(0);
            arr[i][1] = points.get(i).get(1);
        }

        quickSelect(arr, 0, arr.length - 1, k);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(Arrays.asList(arr[i][0], arr[i][1]));
        }

        return result;
    }
    public static void quickSelect(int[][] points, int left, int right, int k) {
        while (left <= right) {
            int pivotIdx = partition(points, left, right);
            if (pivotIdx == k) return;
            else if (pivotIdx < k) left = pivotIdx;
            else right = pivotIdx - 1;
        }
    }

    public static int partition(int[][] points, int left, int right) {
        int[] pivot = points[left + (right - left) / 2];
        int pivotDistance = distance(pivot);
        while (left <= right) {
            while (distance(points[left]) < pivotDistance) left++;
            while (distance(points[right]) > pivotDistance) right--;
            if (left <= right) {
                swap(points, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
            Arrays.asList(1,3),
            Arrays.asList(-2,2)
        );
        int k = 1;
        System.out.println(solve(input, k));
    }
}
