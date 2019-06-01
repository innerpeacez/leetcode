package com.zhw.leetcode.string;

/**
 * @author: zhaihongwei
 * @date: 2018/8/20 16:10
 * @Description: 题目：反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseString3(String s) {
        char[] chars = s.toCharArray();
        char temp;
        int length = chars.length;
        for (int i = 0 ,j = length -1; i < length / 2 ; i++,j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(reverseString3(s));
    }
}
