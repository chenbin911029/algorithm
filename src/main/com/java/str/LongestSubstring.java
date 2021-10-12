package main.com.java.str;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 3 无重复字符的最长子串
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //数据字典cnt，记录滑动窗口字符
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        //记录最长无重复子串的长度
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            //修改滑动窗口
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            //r指针向右移动
            r++;

            while(cnt.get(c) > 1) {
                //判断是否可以收缩l指针
                char d = s.charAt(l);
                //修改滑动窗口
                cnt.put(d, cnt.getOrDefault(d, 0) - 1);
                //l指针向右移动
                l++;
            }
            //更新答案
            res = Math.max(res, r - l);
        }
        return res;
    }
}
/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
