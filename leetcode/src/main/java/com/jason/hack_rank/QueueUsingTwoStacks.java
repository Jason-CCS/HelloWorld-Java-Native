package com.jason.hack_rank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Queue using Two Stacks
 * This is a good example to understand the amortized time.
 * Poll() and peek() needs O(k) times when the popStack is empty.
 * K is the current number of elements in pushStack.
 * However, most time is O(1), So O((k+1*(k-2))/k) = O(1).
 */
public class QueueUsingTwoStacks {

    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;

    public QueueUsingTwoStacks() {
        this.pushStack = new ArrayDeque<>();
        this.popStack = new ArrayDeque<>();
    }

    private void offer(int x) {
        pushStack.push(x);
        System.out.println(pushStack.toString());
    }

    private void poll() {
        if (popStack.isEmpty()) {
            popAllFromPushStack(popStack);
        }
        Integer dequeue = popStack.pop();
        System.out.printf("pop out %d%n", dequeue);
    }

    private void popAllFromPushStack(Deque<Integer> popStack) {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    private void peek() {
        if (popStack.isEmpty()) {
            popAllFromPushStack(popStack);
        }
        System.out.println(this.popStack.peek());
    }


    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        Scanner scanner = new Scanner(System.in);
        String queries = scanner.nextLine();
        int times = Integer.parseInt(queries);
        for (int i = 0; i < times; i++) {
            String query = scanner.nextLine();
            String[] commands = query.split(" ");
            if (commands.length == 1) {
                switch (Integer.parseInt(commands[0])) {
                    case 2:
                        queue.poll();
                        break;
                    case 3:
                        queue.peek();
                        break;
                }
            } else { // length == 2
                queue.offer(Integer.parseInt(commands[1]));
            }
        }
        scanner.close();
    }
}
