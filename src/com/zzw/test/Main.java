package com.zzw.test;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 7, 10, 10, 14};
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            count += 1;
        }
        System.out.println(count + 1);
    }

}
