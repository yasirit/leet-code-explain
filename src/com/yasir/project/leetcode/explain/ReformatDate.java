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
public class ReformatDate {

    /*
        给你一个字符串 date ，它的格式为 Day Month Year ，其中：

        Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
        Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
        Year 的范围在 ​[1900, 2100] 之间。
        请你将字符串转变为 YYYY-MM-DD 的格式，其中：

        YYYY 表示 4 位的年份。
        MM 表示 2 位的月份。
        DD 表示 2 位的天数。

        示例 1：
        输入：date = "20th Oct 2052"
        输出："2052-10-20"
        示例 2：
        输入：date = "6th Jun 1933"
        输出："1933-06-06"
        示例 3：
        输入：date = "26th May 1960"
        输出："1960-05-26"
     */

    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
    }

    private static String reformatDate(String date) {
        Map<String, String> monthMap = new HashMap<>(16);
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] arr = date.split(" ");
        String day = arr[0].replace("st", "").replace("nd", "").replace("rd", "").replace("th", "");
        int dayInt = Integer.valueOf(day);
        if (dayInt < 10) {
            day = "0" + day;
        }
        String month = monthMap.get(arr[1]);
        String year = arr[2];
        return new StringBuilder(year).append("-").append(month).append("-").append(day).toString();
    }

}
