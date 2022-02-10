package com.yasir.project.leetcode.explain;


import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明
 *
 * @author 沈益鑫
 * @version 1.0.0
 * @date 2022/1/11
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInteger2("MCMXCIV"));
    }

    private static int romanToInteger2(String s) {
        s = s.replace("CM", "a");
        s = s.replace("CD", "b");
        s = s.replace("XC", "c");
        s = s.replace("XL", "d");
        s = s.replace("IX", "e");
        s = s.replace("IV", "f");
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum+=switchValue(s.charAt(i));
        }
        return sum;
    }

    private static int switchValue(char c) {
        switch (c) {
            case 'a' : return 900;
            case 'b' : return 400;
            case 'c' : return 90;
            case 'd' : return 40;
            case 'e' : return 9;
            case 'f' : return 4;
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    private static int romanToInteger(String s) {
        //数据初始化
        Map<String, Integer> oneMap = new HashMap<>();
        oneMap.put("I", 1);
        oneMap.put("V", 5);
        oneMap.put("X", 10);
        oneMap.put("L", 50);
        oneMap.put("C", 100);
        oneMap.put("D", 500);
        oneMap.put("M", 1000);

        Map<String, Integer> twoMap = new HashMap<>();
        twoMap.put("IV", 4);
        twoMap.put("IX", 9);
        twoMap.put("XL", 40);
        twoMap.put("XC", 90);
        twoMap.put("CD", 400);
        twoMap.put("CM", 900);

        int sum = 0;
        char[] arr = s.toCharArray();
        String oneChar = "";
        String twoChar = "";
        for(int i = 0; i < arr.length;) {
            oneChar = String.valueOf(arr[i]);
            int y = i + 1;
            if(y < arr.length) {
                twoChar = oneChar + String.valueOf(arr[y]);
            } else {
                twoChar = oneChar;
            }

            if(twoMap.containsKey(twoChar)) {
                sum += twoMap.get(twoChar);
                i = i+2;
            } else {
                sum += oneMap.get(oneChar);
                i = i+1;
            }
        }
        return sum;
    }

}
