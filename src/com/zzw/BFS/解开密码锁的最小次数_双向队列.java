package com.zzw.BFS;

import java.util.HashSet;
import java.util.Set;

public class 解开密码锁的最小次数_双向队列 {
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
        // 用set而不用队列，可以快速判断是否存在
        Set<String> visited = new HashSet<>();
        // 头队列
        Set<String> q1 = new HashSet<>();
        // 尾队列
        Set<String> q2 = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点*/
                if (deads.contains(cur))
                    continue;
                // 用q2来判断是否已经包含
                if (q2.contains(cur))
                    return step;
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}
