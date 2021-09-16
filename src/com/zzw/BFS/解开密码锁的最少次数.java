package com.zzw.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @param
 * @author Zhangzhiwei
 * @Description: 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @return
 * @date 2021/9/15 2:58 PM
 */
public class 解开密码锁的最少次数 {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        int i = openLock(deadends, "0202");
        System.out.println(i);
    }

    // 向上拨动一次
    private static String plusOne(String s, int j) {
        char[] array = s.toCharArray();
        if (array[j] == '9') {
            array[j] = '0';
        } else {
            array[j] += 1;
        }
        return new String(array);
    }


    // 向下拨动一次
    private static String minusOne(String s, int j) {
        char[] array = s.toCharArray();
        if (array[j] == '0') {
            array[j] = '9';
        } else {
            array[j] -= 1;
        }
        return new String(array);
    }

    private static int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            // 当前队列中节点向周围扩散
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                /* 判断是否到达终点*/
                if (deads.contains(cur))
                    continue;
                // 若当前等于目标值，则返回step
                if (cur.equals(target)) {
                    return step;
                }

                /*将一个节点未遍历相邻节点加入队列*/
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer((down));
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
