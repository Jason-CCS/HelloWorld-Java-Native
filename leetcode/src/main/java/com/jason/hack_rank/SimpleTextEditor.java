package com.jason.hack_rank;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class SimpleTextEditor {
    private static Deque<Object> undoStack = new ArrayDeque<>();
    private static String str = "";

    private static void append(String w, boolean flag) {
        Integer len = w.length();
        str = str.concat(w);
        if(flag)
            undoStack.push(len);
    }

    private static void delete(Integer k, boolean flag) {
        if(flag) undoStack.push(str.substring(str.length() - k));
        str = str.substring(0, str.length() - k);
    }

    private static void print(int k) {
        if (k < 1) throw new RuntimeException("not allow k less than 1");
        System.out.println(str.charAt(k - 1));
    }

    private static void undo() {
        Object operation = undoStack.pop();
        if (operation instanceof String) {
            append((String) operation, false);
        } else {
            delete((Integer) operation, false);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, times).forEach(i -> {
            try {
                String s = bufferedReader.readLine();
                String[] ops = s.split(" ");
                if (ops[0].equals("1")) {
                    append(ops[1], true);
                } else if (ops[0].equals("2")) {
                    delete(Integer.parseInt(ops[1]), true);
                } else if (ops[0].equals("3")) {
                    print(Integer.parseInt(ops[1]));
                } else if (ops[0].equals("4")) {
                    undo();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
