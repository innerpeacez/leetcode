package com.zhw.leetcode.string;

/**
 * @author: zhaihongwei
 * @date: 2018/8/23 11:37
 * @Description: 题目：验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;

        String lowerCase = s.toLowerCase();

        int i = 0, j = lowerCase.length() - 1;

        while (i <= j) {
            char chi = lowerCase.charAt(i);
            char chj = lowerCase.charAt(j);

            while (chi < '0'|| (chi > '9' && chi <'a') || chi >'z') {
                i++;
                if (i > j) return true;
                chi = lowerCase.charAt(i);
            }

            while (chj < '0'|| (chj > '9' && chj <'a') || chj >'z') {
                j--;
                if (i > j) return true;
                chj = lowerCase.charAt(j);
            }

            if (chi != chj) return false;

            i++;
            j--;
        }
        return true;
    }


    public static boolean isPalindrome2(String s) {
        String lowerCase = s.toLowerCase();
        int i = 0, j = lowerCase.length() - 1;
        while (i <= j) {
            char chi = lowerCase.charAt(i);
            char chj = lowerCase.charAt(j);

            if (isNotValidChar(chi)) {
                i++;
            } else if (isNotValidChar(chj)) {
                j--;
            } else if (chi != chj) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static boolean isNotValidChar(char ch) {
        return ch < '0'|| (ch > '9' && ch <'a') || ch >'z';
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("a"));
    }
}
