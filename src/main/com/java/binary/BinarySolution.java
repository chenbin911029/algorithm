package main.com.java.binary;

/**
 * 寻找⼀个数
 * 即搜索⼀个数，如果存在， 返回其索引，否则返回 -1。
 */
public class BinarySolution {

    int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }

    /**
     * 寻找一个数，返回左边界符合条件的index，没有则返回-1
     */
    int leftBound(int nums[],int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                //锁定左边界
                right = mid - 1;
            }
        }
        //检查数组越界情况，元素是否存在
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找一个数，返回右边界符合条件的index，没有则返回-1
     */
    int rightBound(int nums[],int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                //锁定右边界
                left = mid + 1;
            }
        }
        //检查数组越界，数据是否存在
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
