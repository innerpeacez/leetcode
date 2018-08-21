package com.zhw.leetcode.string;

/**
 * @author: zhaihongwei
 * @date: 2018/8/21 16:26
 * @Description: 题目： 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(String.valueOf(chars[i])) == s.lastIndexOf(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar4(String s) {
        for (int i = 0; i < s.length(); i++) if (s.indexOf(String.valueOf(s.charAt(i))) == s.lastIndexOf(s.charAt(i))) return i;
        return -1;
    }

    public int firstUniqChar2(String s) {
        int result = -1;
        for(char c = 'a';c<='z';c++){
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)){
                result = result != -1?Math.min(result,index):index;
            }
        }
        return result;
    }

    public int firstUniqChar3(String s) {
        int result = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                result = result != -1 ? Math.min(result, index) : index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar4("loveleetcode"));
    }
}
