package com.jason.stack_and_queue;

/**
 * Problem: 49
 * Difficulty: Medium
 * At the beginning, I am not able to figure out how to have an updated min value in a normal stack.
 * I am thinking you always have to have at least O(log(n)) to maintain a min heap.
 * But I forget you can store any value in the node to preserve any auxiliary information, like the state machine concept.
 * So the key here is to have a member value "int min" to retain the previous min value when you pop the current node.
 */
public class MinStack {
    private Node top;

    public MinStack() {

    }

    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            top = new Node(val, Math.min(val, top.min), top);
        }
    }

    public void pop() {
        top = top.previous;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

    private class Node {
        int val;
        int min; // key point here.
        Node previous;

        public Node(int val, int min, Node previous) {
            this.val = val;
            this.min = min;
            this.previous = previous;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
