package main.com.java.recall;

import org.junit.Test;

import java.util.*;

/**
 * N皇后问题
 * 给你⼀个 N×N 的棋盘，让你放置 N 个 皇后，使得它们不能互相攻击。
 * 皇后可以攻击同⼀⾏、同⼀列、左上左下右上右下四个⽅向的任意单位。
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //记录每行Q所在的列号
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        //记录已有Q的列号
        Set<Integer> columns = new HashSet<>();
        //左上右下斜线 row - i
        Set<Integer> diagonal1 = new HashSet<>();
        //右上左下斜线 row + i
        Set<Integer> diagonal2 = new HashSet<>();
        //.表示空，'Q'表示皇后，初始化空棋盘
        backtrack(res, queens, n, 0, columns, diagonal1, diagonal2);
        return res;
    }

    void backtrack(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        //终止条件
        if (n == row) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            //排除不符合的条件，跟Q同一列，同斜线
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            //做出选择
            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(res, queens,n, row + 1,  columns, diagonals1, diagonals2);
            //撤销选择
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    List<String> generateBoard(int[] queens,int n) {
        List<String> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            //初始化棋盘，'.'表示空格
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    @Test
    public void testNQueens() {
        //[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
        System.out.println(solveNQueens(4));
    }
}
