package com.coderli.algorithm;

/**
 * @author li.hzh
 * @date 2017-09-19 21:49
 */
public class MaxSubArraySum {
    
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = nums[0];
        int maxCurrent = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //
            maxCurrent += nums[i];
            maxCurrent = Math.max(maxCurrent, nums[i]);
            maxSum = Math.max(maxSum, maxCurrent);

        }
        System.out.println(maxSum);
    }
}
