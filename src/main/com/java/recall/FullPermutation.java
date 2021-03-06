package main.com.java.recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组，元素不重复
 * 返回它的全排列，列出它的所有排列组合
 */
public class FullPermutation {

    public List<List<Integer>> arrFullList(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, res);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
        //满足终止条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        //选择列表
        for (int num : nums) {
            //排除
            if (track.contains(num)) {
                continue;
            }
            //做选择
            track.add(num);
            //回溯
            backtrack(nums, track, res);
            //撤销选择
            track.removeLast();
        }
    }

    @Test
    public void testArrFull() {
        int[] nums = {1,2,3,4};
        List<List<Integer>> res = arrFullList(nums);
        System.out.println(res.size());
        System.out.println(res);
    }
}
