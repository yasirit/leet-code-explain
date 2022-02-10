package com.yasir.project.leetcode.explain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 功能说明
 *
 * @author 沈益鑫
 * @version 1.0.0
 * @date 2022/1/11
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    private static String longestCommonPrefix(String[] strArr) {
        //按照字符个数从小到大排序
        Arrays.sort(strArr, Comparator.comparing(s -> s.length()));
        String str = strArr[0];
        for(int i = str.length(); i > 0; i--) {
            int count = 1;
            String source = str.substring(0, i);
            for(int y = 1; y < strArr.length; y++) {
                String target = strArr[y];
                if(target.indexOf(source) == 0) {
                    count++;
                } else {
                    continue;
                }
            }
            if(count == strArr.length) {
                return source;
            }
        }
        return "";
    }

}
