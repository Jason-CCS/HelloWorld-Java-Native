package com.jason.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackAgain {
    private Integer min;
    private Deque<Elem> stack = new ArrayDeque<>();

    public MinStackAgain() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            Elem elem = new Elem(val, null);
            min = val;
            stack.push(elem);
        } else {
            Elem elem = new Elem(val, min);
            min = Math.min(min, val);
            stack.push(elem);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Elem elem = stack.pop();
            min = elem.previousMin;
        }
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return min;
    }

    static class Elem {
        Integer val;
        Integer previousMin;

        public Elem(Integer val, Integer previousMin) {
            this.val = val;
            this.previousMin = previousMin;
        }
    }

    public static void main(String[] args) {
        MinStackAgain minStack = new MinStackAgain();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
