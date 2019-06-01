package com.zhw.leetcode.array;

import java.util.*;

/**
 * @author: zhaihongwei
 * @date: 2018/8/1 21:30
 * @Description: 题目：  两个数组的交集 II
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List list1 = new ArrayList();
        List list = new ArrayList();
        for (int i : nums1) {
            Integer integer = i;
            list1.add(integer);
        }
        Integer temp;
        for (int i = 0; i < nums2.length; i++) {
            if (list1.contains(nums2[i])) {
                temp = nums2[i];
                list.add(temp);
                list1.remove(temp);
                if (list1.size() == 0) {
                    break;
                }
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) list.get(i);
        }
        return nums;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] nums = new int[nums1.length>nums2.length?nums2.length:nums1.length];

        int i = 0, j = 0,k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] numss = new int[k];
        System.arraycopy(nums,0,numss,0,k);
        return numss;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] ints = intersect2(num1, num2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
