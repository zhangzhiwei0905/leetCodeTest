package com.zzw.回溯法;


import java.util.ArrayList;
import java.util.List;

/*
*
*
* 解决一个回溯问题，实际上就是一个决策树的遍历过程。你只需要思考 3 个问题：

1、路径：也就是已经做出的选择。

2、选择列表：也就是你当前可以做的选择。

3、结束条件：也就是到达决策树底层，无法再做选择的条件。
* */


// 后续可以有优化的地方：因为对链表使用 contains 方法需要 O(N) 的时间复杂度
public class 全排列 {
    static List<List<Integer>> res = new ArrayList<>();


    public static void main(String[] args) {
        int num[] = {1, 2, 3, 4, 5};
        List<List<Integer>> lists = permute(num);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track);
        return res;
    }

    private static void backTrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
