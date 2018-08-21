package com.zhw.leetcode.string;

/**
 * @author: zhaihongwei
 * @date: 2018/8/21 11:24
 * @Description: 题目： 颠倒整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseNumber {


    public static int reverse(int x) {
        char[] chars = String.valueOf(x).replace("-", "").toCharArray();
        char temp;
        int length = chars.length;
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        long result = Long.parseLong(new String(chars));
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (x > 0 ? result : -result);
    }


    public static int reverse2(int x) {
        long result = 0;
        long input = x;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            input = x * -1L;
        }
        while (input > 0) {
            result = result * 10 + input % 10;
            input = input / 10;
        }

        if (negative) {
            result *= -1;
        }

        if (result < Integer.MIN_VALUE) {
            result = 0;
        } else if (result > Integer.MAX_VALUE) {
            result = 0;
        }

        return Long.valueOf(result).intValue();
    }

    public static int reverse3(int x) {
        int abs = x > 0 ? x : -x;
        long result = 0;
        while (abs != 0) {
            result = result * 10 + abs % 10;
            abs /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        int res = (int) result;
        return x > 0 ? res : -res;
    }

    public int reverse4(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse5(int x) {
        int next = x;
        int pop = 0;
        int result = 0;
        do {
            pop = next % 10;
            next /= 10;
            if (result < Integer.MIN_VALUE / 10 || result * 10 == Integer.MAX_VALUE && pop < -8) {
                return 0;
            }
            if (result > Integer.MAX_VALUE / 10 || result * 10 == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            result = result * 10 + pop;
        }
        while (next != 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }
}
