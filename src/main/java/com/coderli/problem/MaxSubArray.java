package com.coderli.problem;

public class MaxSubArray {

    public static void main(String[] args) {
        int input[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSoFar = input[0];
        int maxEnding = input[0];
        for (int i = 1; i < input.length; i++)
        {
            maxEnding = maxEnding + input[i];
            maxEnding = Math.max(maxEnding, input[i]);
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        System.out.println(maxSoFar);
    }

}
