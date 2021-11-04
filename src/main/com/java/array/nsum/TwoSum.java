package main.com.java.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回不重复两个数相加等于target的所有组合
 */
public class TwoSum {
    /**
     * 使用双指针
     */
    public List<int[]> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = n - 1;

        List<int[]> res  = new ArrayList<>();
        while (low < high) {
            int left = nums[low], right = nums[high];
            int sum = nums[low] + nums[high];
            if (sum < target) {
                while (low < high && left == nums[low]) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && right == nums[high]) {
                    high--;
                }
            } else {
                res.add(new int[]{low, high});
                while(low < high && left == nums[low]) {low++;}
                while (low < high && right == nums[high]) {right--;}
            }
        }
        return res;
    }

}
