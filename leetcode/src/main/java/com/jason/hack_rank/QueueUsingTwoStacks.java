package com.jason.hack_rank;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Queue using Two Stacks
 */
public class QueueUsingTwoStacks {

    private Deque<Integer> pushtStack;
    private Deque<Integer> popStack;
    private int front = 0;

    public QueueUsingTwoStacks() {
        this.pushtStack = new LinkedList<>();
        this.popStack = new LinkedList<>();
    }

    private void push(int x) {
        if (pushtStack.isEmpty())
            front = x;
        pushtStack.push(x);
    }

    private int pop() {
        while (!pushtStack.isEmpty()) {
            popStack.push(pushtStack.pop());
        }
        int dequeue = popStack.pop();
        while (!popStack.isEmpty()) {
            pushtStack.push(popStack.pop());
        }
        return dequeue;
    }

    private void print() {
        System.out.println(this.front);
    }


    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        Scanner scanner = new Scanner(System.in);
        String querys = scanner.nextLine();
        int times = Integer.parseInt(querys);
        for (int i = 0; i < times; i++) {
            String query = scanner.nextLine();
            String[] commands = query.split(" ");
            if (commands.length == 1) {
                switch (Integer.parseInt(commands[0])) {
                    case 2:
                        queue.pop();
                        break;
                    case 3:
                        queue.print();
                        break;
                }
            } else { // length == 2
                queue.push(Integer.parseInt(commands[1]));
            }
        }
    }
}
