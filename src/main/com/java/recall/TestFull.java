package main.com.java.recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不重复元素的数组，返回它的全排列
 */
public class TestFull {
    public List<List<Integer>> arrFullList(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> board = new LinkedList<>();
        backtrack(res, board, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, LinkedList<Integer> board, int[] nums) {
        //满足结束条件
        if (board.size() == nums.length) {
            res.add(new LinkedList(board));
            return;
        }
        //选择列表
        for (int num : nums) {
            //排除不符合的选项
            if (board.contains(num)) {
                continue;
            }
            //做选择
            board.add(num);
            //回溯
            backtrack(res, board, nums);
            board.removeLast();
        }
    }

    @Test
    public void fullTest() {
        int[] nums = {1,2,3};
        List<List<Integer>> res = arrFullList(nums);
        System.out.println(res);
    }
}
