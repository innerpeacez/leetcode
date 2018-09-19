package com.zhw.leetcode.array;

/**
 * @author: zhaihongwei
 * @date: 2018/8/9 11:40
 * @Description: 题目 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums!=null && nums.length == 1)
            return;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if(index != i)
                    nums[i] = 0;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}


// public void moveZeroes2(int[] nums) {
//         int zeroNum=0;//用来计算0的个数
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
//                 zeroNum++;
//             }else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
//                 nums[i-zeroNum]=nums[i];  
//                 nums[i]=0;
//             }
//         }
//     }
