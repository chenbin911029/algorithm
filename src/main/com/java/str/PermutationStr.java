package main.com.java.str;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 567, 字符串的排列
 */
public class PermutationStr {
    public boolean checkInclusion(String s1, String s2) {
        //数据字典ori，记录目标字符串的k,v
        Map<Character, Integer> ori = new HashMap<>();
        int tLen = s1.length();
        for (int i = 0;i < tLen;i++) {
            ori.put(s1.charAt(i), ori.getOrDefault(s1.charAt(i), 0) + 1);
        }
        //数据字典cnt，记录滑动窗口字符串的k,v
        Map<Character, Integer> cnt = new HashMap<>();
        //valid记录符合目标字符的不重复的计数
        int valid = 0, l = 0, r = 0;
        while(r < s2.length()) {
            char newChar = s2.charAt(r);
            //修改滑动窗口字符串
            if (ori.get(newChar) != null) {
                cnt.put(newChar, cnt.getOrDefault(newChar, 0) + 1);
                if  (ori.get(newChar).equals(cnt.get(newChar))) {
                    //符合的不重复字符串计数
                    valid++;
                }
            }
            //r指针向右滑动
            r++;
            while (r - l == s1.length()) {
                if (valid == ori.size()) {
                    return true;
                }

                char removeChar = s2.charAt(l);
                //修改滑动窗口字符
                if (ori.get(removeChar) != null) {
                    if (ori.get(removeChar).equals(cnt.get(removeChar))) {
                        valid--;
                    }
                    cnt.put(removeChar, cnt.getOrDefault(removeChar, 0) - 1);
                }
                //l指针向右移动
                l++;
            }
        }
        return false;
    }

}
/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */