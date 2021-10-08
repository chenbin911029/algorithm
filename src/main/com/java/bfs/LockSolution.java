package main.com.java.bfs;


import java.util.*;

/**
 * LeetCode 752
 * 打开转盘锁，广度遍历BFS
 */
public class LockSolution {

    public int openLock(String[] deadends, String target) {
        //核心数据
        Queue<String> q = new LinkedList<>();

        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0;i < sz;i++) {
                String cur = q.poll();
                System.out.println(cur);
                //判断是否到达终点
                if (target.equals(cur)) {
                    return step;
                }
                //deadend，此路不通
                if (deads.contains(cur)) {
                    continue;
                }
                //将一个节点的相邻节点加入队列
                for (int j = 0;j < 4;j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            //这里增加步数
            step++;
        }
        //穷举完找不到密码目标，返回-1
        return -1;
    }

    /**
     * s[j]向上拨一位
     * @param s
     * @param j
     * @return
     */
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return new String(ch);
    }

    /**
     * s[j]向下拨一位
     * @param s
     * @param j
     * @return
     */
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') ch[j] = '9';
        else ch[j] -= 1;
        return new String(ch);
    }
}
/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */