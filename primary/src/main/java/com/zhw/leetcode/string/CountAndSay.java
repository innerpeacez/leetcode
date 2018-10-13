package com.zhw.leetcode.string;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 *
 * @author innerpeacez
 * @since 2018/10/13
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String result = "1";
        int sameCount = 0;
        // 需要数多少次
        char tempCh = result.charAt(0);

        if(n == 1) return result;

        for (int i = n; i > 1; i--) {

            // 判断字符串中的字节是否相同

            for (int j = 0; j < result.length(); j++) {
                if(result.charAt(j) == tempCh) {
                    sameCount ++;
                }
                else {

                }

            }

            result = sameCount + result;

        }

        return result;
    }

    public static String next(String num) {
        String ans = "";
        int i = 0;
        while (i < num.length()) {
            char ch = num.charAt(i);
            int cnt = 0;
            while (i < num.length() && ch == num.charAt(i)) {
                i++;
                cnt++;
            }
            ans += cnt;
            ans += ch;
        }
        return ans;
    }

    public static String countAndSay2(int n) {
        String num = "1";
        while (--n > 0) {
            num = next(num);
        }
        return num;
    }


    public static void main(String[] args) {
        String s = countAndSay3(30);
        System.out.println(s);
    }

    public static String countAndSay3(int n) {
        String start = "1";
        char temp;
        int count=0;
        while(--n > 0){
            char chars[] = start.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i=0;
            while(i<chars.length){
                count=0;
                temp = chars[i];
                while(i<chars.length && chars[i]==temp){
                    count++;
                    i++;
                }
                sb.append(count).append(temp);
            }
            start = sb.toString();
        }
        return start;
    }


}
