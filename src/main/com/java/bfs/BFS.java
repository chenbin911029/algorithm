package main.com.java.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开轮盘锁，leetCode 752
 */
public class BFS {
    public int openLock(String[] deadends, String target) {
        //如果有入参，检验入参，是否终止条件 return 0;
        //核心数据用队列记录
        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Set<String> dead = new HashSet<>();
        if (deadends != null && deadends.length > 0) {
            for (String s : deadends) {
                dead.add(s);
            }
        }

        //深度初始值
        int step = 0;

        //遍历队列
        while(!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0;i < sz; i++) {
                String cur = q.poll();
                //判断终止条件
                if (cur.equals(target)) {
                    return step;
                }
                //判断是否到滤条件
                if (dead.contains(cur)) {
                    continue;
                }
                //遍历相邻兄弟节点，广度遍历，四个轮盘，上下方向转动
                for (int j = 0; j < 4; j++) {
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
            step++;
        }
        //无解返回 -1
        return -1;
    }

    /**
     * 第j位向上拨一位
     * @param cur
     * @param j
     * @return
     */
    public String plusOne(String cur,int j) {
        char[] c = cur.toCharArray();
        if (c[j] == '9') {
            c[j] = '0';
        } else {
            c[j] += 1;
        }
        return new String(c);
    }

    /**
     * 第j位向下拨一位
     * @param cur
     * @param j
     * @return
     */
    public String minusOne(String cur,int j) {
        char[] c = cur.toCharArray();
        if (c[j] == '0') {
            c[j] = '9';
        } else {
            c[j] -= 1;
        }
        return new String(c);
    }
}
