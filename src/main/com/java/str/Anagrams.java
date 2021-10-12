package main.com.java.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        //记录符合子串的起始索引
        List<Integer> result = new ArrayList<>();
        //数据字典ori记录目标字符串k,v
        Map<Character, Integer> ori = new HashMap<>();
        int pLen = p.length();
        for (int i = 0;i < pLen;i++) {
            char c = p.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        //数据字典cnt记录滑动窗口字符串k,v
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        //p中不重复字符计数
        int valid = 0;

        while(r < s.length()) {
            //修改滑动窗口
            char newChar = s.charAt(r);
            if (ori.containsKey(newChar)) {
                cnt.put(newChar, cnt.getOrDefault(newChar, 0) + 1);
                if (ori.get(newChar).equals(cnt.get(newChar))) {
                    valid++;
                }
            }
            //r指针向右移动
            r++;

            while(r - l == p.length()) {
                if (valid == ori.size()) {
                    //符合异位词的起始索引
                    result.add(l);
                }
                //修改滑动窗口
                char removeChar = s.charAt(l);
                if (ori.containsKey(removeChar)) {
                    if (ori.get(removeChar).equals(cnt.get(removeChar))) {
                        valid--;
                    }
                    cnt.put(removeChar, cnt.getOrDefault(removeChar, 0) - 1);
                }
                //l指针向右移动
                l++;
            }
        }
        return result;
    }
}
/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
