package com.study.demo.leetcode;

public class Solutions {
    public static void main(String[] args) {
        /*int[] nums = {2, 7, 11, 15, 3,7,8,9,2};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] +"-"+ res[1]);*/


    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0; i< nums.length; i++) {
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }


}
