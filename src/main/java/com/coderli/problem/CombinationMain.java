package com.coderli.problem;

public class CombinationMain {

    public static void main(String[] args) {
        String str = "07,09,12,13,15,16,18,22,30,32,41,47,53,55,61,62,63,64,78,80";
        String[] strArray = str.split(",");
        int len = strArray.length;
        int n = 1 << len;
        int count = 0;
        StringBuilder sb = null;
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) // 对应位上为1，则输出对应的字符
                {
                    count++;
                    sb.append(strArray[j]);
                }
            }
            if (count == 4) {
                totalCount++;
                System.out.println(sb + " ");
            }
            count = 0;
        }
        System.out.println("Total Count: " + totalCount);
    }


}
