package com.zhw.leetcode.structure;

public class Stack {

    private volatile int capacity;
    private int[] arr;
    private volatile int top = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }

    // 时间复杂度 O(1)
    public synchronized void push(int num) {
        if (full()) {
            throw new RuntimeException("overflow");
        }
        arr[top++] = num;
    }

    // 时间复杂度 O(1)
    public synchronized int pop() {
        if (empty()) {
            throw new RuntimeException("underflow");
        }
        return arr[--top];
    }

    public boolean empty() {
        return top == 0;
    }

    public boolean full() {
        return top == capacity;
    }

}
