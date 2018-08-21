package com.zhw.leetcode.array;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: zhaihongwei
 * @date: 2018/8/9 20:39
 * @Description: 题目 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (flag)
                break;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    temp[0] = i;
                    temp[1] = j;
                    flag = true;
                    break;
                }
            }
        }
        return temp;
    }

    public static int[] twoSum2(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            list.add(target - nums[i]);
            list2.add(nums[i]);
        }
        Integer temp = null;
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                ints[0] = i;
                ints[1] = list2.indexOf(nums);
            }
        }
        return ints;
    }

    public static int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2)
            return res;

        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
            if (min > nums[i])
                min = nums[i];
        }

        int[] index = new int[max - min + 1];
        int other;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (index[other - min] > 0) {
                res[0] = index[other - min] - 1;
                res[1] = i;
                return res;
            }
            index[nums[i] - min] = i + 1;
        }
        return res;
    }

    public static int[] twoSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && map.get(sub) != i) {
                res[0] = i;
                res[1] = map.get(sub);
                break;
            }
        }
        return res;
    }

    public static int[] twoSum5(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5,6, 5};
        int target = 10;
        int[] ints = twoSum3(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
