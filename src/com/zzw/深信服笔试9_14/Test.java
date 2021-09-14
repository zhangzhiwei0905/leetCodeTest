package com.zzw.深信服笔试9_14;

public class Test {
    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7};
//        int[] res = shuffle(nums, 2);
//        System.out.println(Arrays.toString(res));
        String s = "how are you? i am fine !";
        String s1 = reverseWords(s, 3);
        System.out.println(s1);
    }

    // 数组重组，从第i+1位开始，分为前后两个数组，前后两数组交替放到新数组中
//    public static int[] shuffle(int[] arr, int i) {
//        // write code here
//        if (i >= arr.length) {
//            return arr;
//        }
//        if (arr.length == 0 || arr == null) {
//            return arr;
//        }
//        int[] res = new int[arr.length];
//        int prev_last = i - 1;
//        int prev_first = 0;
//        int next_first = prev_last + 1;
//        int index = 0;
//        while (prev_first <= prev_last || next_first < arr.length) {
//            if (prev_first <= prev_last) {
//                res[index++] = arr[prev_first++];
//            }
//            if (next_first < arr.length) {
//                res[index++] = arr[next_first++];
//            }
//        }
//        return res;
//    }

    // 翻转单词顺序
    // 第一个到第i个顺序翻转，第i+1个到最后顺序翻转
    public static String reverseWords(String s, int i) {
        // write code here
        String[] words = s.split(" ");
        int len = words.length;
        if (len == 0) {
            return "";
        }
        String[] result = new String[words.length];
        if (i >= len) {
            int prev_last = i - 1;
            String prev_tmp = words[prev_last];
            result[0] = prev_tmp;
            for (int j = 1; j <= prev_last; j++) {
                result[j] = words[j - 1];
            }
        } else {
            int prev_last = i - 1;
            int next_first = prev_last + 1;
            String prev_tmp = words[prev_last];
            String next_tmp = words[words.length - 1];
            result[0] = prev_tmp;
            for (int j = 1; j <= prev_last; j++) {
                result[j] = words[j - 1];
            }
            result[next_first] = next_tmp;
            for (int k = next_first + 1; k < words.length; k++) {
                result[k] = words[k - 1];
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(result[0]);
        for (int q = 1; q < result.length; q++) {
            stringBuffer.append(" " + result[q]);
        }
        return stringBuffer.toString();
    }
}
