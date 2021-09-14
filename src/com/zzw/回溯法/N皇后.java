package com.zzw.回溯法;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* 给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击。

PS：皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
*
*
* */
public class N皇后 {

    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(5);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        // 一行一行开始放置皇后
        backtrack(board, 0);
        return res;
    }


    // 回溯
    public static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToList(board));
            return;
        }
        int n = board[row].length;
        // 当前行的每一列都可能放置皇后
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }

    }

    /* 判断是否可以在 board[row][col] 放置皇后 */
    public static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    // 将数组转化为列表
    public static List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            /*
            *
            * copyValueOf() 方法有两种形式：

             public static String copyValueOf(char[] data): 返回指定数组中表示该字符序列的字符串。

             public static String copyValueOf(char[] data, int offset, int count): 返回指定数组中表示该字符序列的 字符串。count为字符串长度
            *
            * */
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
