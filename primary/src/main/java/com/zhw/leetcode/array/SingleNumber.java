package com.zhw.leetcode.array;

import java.util.Arrays;

/**
 * @author: zhaihongwei
 * @date: 2018/7/31 10:31
 * @Description: 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {

        if (nums != null && nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int i;
        for (i = 1; i < nums.length - 1; i++) {
            if ((i - 1) == 0) {
                if (nums[i] != nums[i - 1]) {
                    i--;
                    break;
                } else {
                    continue;
                }
            }
            if ((i + 1) == nums.length - 1) {
                if (nums[i + 1] != nums[i]) {
                    i++;
                    break;
                } else {
                    continue;
                }
            }
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1])
                break;
        }
        return nums[i];
    }

    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2,4};
        System.out.println(singleNumber2(nums));
    }
}
