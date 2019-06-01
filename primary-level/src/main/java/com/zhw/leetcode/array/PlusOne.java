package com.zhw.leetcode.array;

/**
 * @author: zhaihongwei
 * @date: 2018/8/8 19:13
 * @Description: 题目：加一
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 10) {
                break;
            }
            digits = plus(digits, i);
        }
        return digits;
    }

    public static int[] plus(int[] digits, int index) {
        if (digits[index] == 10) {
            digits[index] = 0;
            if (index - 1 < 0) {
                digits[index] = 0;
                int[] ints = new int[digits.length + 1];
                System.arraycopy(digits, 0, ints, 1, digits.length);
                ints[0] += 1;
                return ints;
            }
            digits[index - 1] += 1;
        }
        return digits;
    }


    public static void main(String[] args) {
        int[] digits = {9};
        int[] ints = plusOne(digits);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
