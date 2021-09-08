package main.com.java.bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 */
public class OpenLockBFS {
    public int openLock(String[] deadends, String target) {
        /**
         * 初始数据“0000”，用visited记录走过的路径
         * 四个数字，每个数位可以向上拨，向下拨，有8种可能，加入到队列种，加入到visited
         * 遇到deadends则跳过，不再往下走
         * 用step记录步数，到达target则返回step，若没有解锁密码，则返回-1
         */
        //核心数据
        String init = "0000";
        Queue<String> q = new LinkedList<>();
        q.offer(init);
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        Set<String> visited = new HashSet<>();
        visited.add(init);
        int step = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0;i < sz;i++) {
                String cur = q.poll();
                if (target.equals(cur)) {
                    return step;
                }
                if (deads.contains(cur)) {
                    continue;
                }
                //向相邻节点扩散，广度遍历，加入到队列，加入到visited
                for (int j = 0;j < 4;j++) {
                    //向上拨一位
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    //向下拨一位
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        //没有解锁密码
        return -1;
    }

    String plusOne(String cur, int j) {
        char[] c = cur.toCharArray();
        if (c[j] == '9') c[j] = '0';
        else c[j] += 1;
        return new String(c);
    }

    String minusOne(String cur, int j) {
        char[] c = cur.toCharArray();
        if (c[j] == '0') c[j] = '9';
        else c[j] -= 1;
        return new String(c);
    }

    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
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
}
