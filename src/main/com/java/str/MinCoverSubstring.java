package main.com.java.str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * leetCode 76. 最小覆盖子串
 */
public class MinCoverSubstring {
    //数据字典ori记录t字符串的k,v
    Map<Character, Integer> ori = new HashMap<>();
    //数据字典cnt记录滑动窗口字符串的k,v
    Map<Character, Integer> cnt = new HashMap<>();
    //滑动窗口
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0;i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c , ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while(r < sLen) {
            //r指针向右滑动，
            ++r;
            //修改滑动窗口
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            while(check() && l <= r) {
                //若len更小则替换
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                //修改滑动窗口
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                //l指针向右划
                ++l;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry)iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */