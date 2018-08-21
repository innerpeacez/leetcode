package com.zhw.leetcode.array;


/**
 * @author: zhaihongwei
 * @date: 2018/7/30 17:15
 * @Description: 题目;
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        /*for (int i =0 ; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }*/
        /*Arrays.sort(nums);
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;*/

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
    }
}
