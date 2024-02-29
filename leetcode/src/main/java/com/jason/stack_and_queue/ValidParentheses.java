package com.jason.stack_and_queue;

import java.util.Arrays;
import java.util.List;

/**
 * The stack problem.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> closeChars = Arrays.asList(')', ']', '}');
        Stack closeStack = new Stack();
        for (char c : s.toCharArray()) {
            if (!closeChars.contains(c)) {
                char close = ' ';
                switch (c) {
                    case '(':
                        close = ')';
                        break;
                    case '[':
                        close = ']';
                        break;
                    case '{':
                        close = '}';
                        break;
                }
                closeStack.put(new Elem(close));
            } else {
                if (closeStack.isEmpty() || closeStack.take().value != c)
                    return false;
            }
        }
        return closeStack.isEmpty();
    }

    public static class Stack {
        private Elem last;

        public Stack() {
        }

        public void put(Elem elem) {
            if (this.last == null) {
                last = elem;
            } else {
                Elem tmp = last;
                last = elem;
                last.previous = tmp;
            }
        }

        public Elem take() {
            Elem out = last;
            last = last.previous;
            return out;
        }

        public boolean isEmpty() {
            return last == null;
        }
    }

    public static class Elem {
        char value;
        Elem previous;

        public Elem(char val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
//        Stack stack = new Stack();
//        stack.put(new Elem('a'));
//        stack.put(new Elem('b'));
//        stack.put(new Elem('c'));
//
//        while (!stack.isEmpty()) {
//            System.out.println(stack.take().value);
//        }

        System.out.println(new ValidParentheses().isValid("([]{([])})"));
        System.out.println(new ValidParentheses().isValid("((([)]))"));
        System.out.println(new ValidParentheses().isValid("("));
        System.out.println(new ValidParentheses().isValid("}"));
    }
}
