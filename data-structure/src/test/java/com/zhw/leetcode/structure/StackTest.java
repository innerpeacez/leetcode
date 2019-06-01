package com.zhw.leetcode.structure;

import org.junit.Test;

public class StackTest {

    @Test
    public void testStack() {
        Stack stack = new Stack(10);

        for (int i = 1; i < 11; i++) {
            stack.push(i);
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
