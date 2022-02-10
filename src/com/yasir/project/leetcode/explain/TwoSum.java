package com.yasir.project.leetcode.explain;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 功能说明
 *
 * @author 沈益鑫
 * @version 1.0.0
 * @date 2022/1/10
 */
public class TwoSum {

    /*
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        你可以按任意顺序返回答案。

        示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        示例 2：
        输入：nums = [3,2,4], target = 6
        输出：[1,2]
        示例 3：
        输入：nums = [3,3], target = 6
        输出：[0,1]
        提示：
        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        只会存在一个有效答案
        进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     */

    public static void main(String[] args) {
        int[] sourceArr = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum3(sourceArr, target)));
    }

    //O(fn^2)
    public static int[] twoSum2(int[] nums, int target) {
        //出参
        int[] dataArr = new int[2];
        boolean done = false;
        for(int i = 0; i < nums.length; i++) {
            int dataFirst = nums[i];
            int dataTarget = target - dataFirst;
            for(int y = nums.length-1; y > i; y--) {
                int dataLast = nums[y];
                if(dataLast == dataTarget) {
                    dataArr[0] = i;
                    dataArr[1] = y;
                    done = true;
                    break;
                }
            }
            if(done) {
                break;
            }
        }
        return dataArr;
    }

    //O(fn)
    public static int[] twoSum3(int[] nums, int target) {
        //出参
        int[] dataArr = new int[2];
        //Map
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for(int i = 0; i < nums.length; i++) {
            int dataFirst = nums[i];
            int dataSub = target - dataFirst;
            if(map.containsKey(dataSub)) {
                dataArr[0] = i;
                dataArr[1] = map.get(dataSub);
                break;
            }
            map.put(dataFirst, i);
        }
        return dataArr;
    }

}
