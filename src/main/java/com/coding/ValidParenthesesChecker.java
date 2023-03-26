package com.coding;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * Write a function that takes a string of parentheses, and determines if the
 * order of the parentheses is valid.
 * The function should return true if the string is valid, and false if it's
 * invalid.
 * 
 * Examples
 * "()" => true
 * ")(()))" => false
 * "(" => false
 * "(())((()())())" => true
 * 
 * Constraints
 * 0 <= input.length <= 100
 */

public class ValidParenthesesChecker {

    public static void main(String[] args) {

        String[] inputStrings = new String[] {
                "((())",
                "(())((()())())",
                "(",
                ")",
                "))",
                "()",
                ")()(",
                null,
                "",
                "  ",
                "{([])}"

        };

        Stream.of(inputStrings)
                .forEach(e -> System.out.printf("%s = %s%n", e, isValid(e)));

    }

    private static boolean isValid(String input) {
        if (input == null || input.isBlank() || input.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        // we can also use DeQueue
        // Deque<Character> stack= new ArrayDeque<>();
        for (char c : input.toCharArray()) {

            // only '(' type of bracket
            /*
             * if (c == '(')
             * stack.push(')');
             * else if (stack.isEmpty() || c != stack.pop())
             * return false;
             */

            // for all types of bracket
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
            }

        }

        return stack.isEmpty();
    }

}
