package com.zhw.leetcode.string;


import java.util.Arrays;

/**
 * @author: zhaihongwei
 * @date: 2018/8/22 15:21
 * @Description: 题目：有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        StringBuilder sb = new StringBuilder(t);
        for (int i = 0; i < s.length(); i++) {
            int firstIndex = sb.indexOf(String.valueOf(s.charAt(i)));
            if (firstIndex == -1) return false;
            sb.deleteCharAt(firstIndex);
        }
        return sb.length() == 0;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return String.valueOf(chars).equals(String.valueOf(chart));
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
