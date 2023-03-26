package com.coding;

import java.util.Arrays;
import java.util.stream.Collectors;

/***
 * For given array of Integers, find an index N where the sum of the integers to the left of N is
 * equal to the sum of the integers to the right of N. If there is no index that
 * would make this happen, return -1.
 * 
 * For example:
 * 
 * Let's say you are given the array {1,2,3,4,3,2,1}:
 * Your function will return the index 3, because at the 3rd position of the
 * array, the sum of left side of the index ({1,2,3}) and the sum of the right
 * side of the index ({3,2,1}) both equal 6.
 * 
 * Let's look at another one.
 * You are given the array {1,100,50,-51,1,1}:
 * Your function will return the index 1, because at the 1st position of the
 * array, the sum of left side of the index ({1}) and the sum of the right side
 * of the index ({50,-51,1,1}) both equal 1.
 */
public class EqualSidesArray {

    public static void main(String[] args) {
        int[] inputArray = new int[] { 1, 2, 3, 4, 3, 2, 1 };

        int midElement = findMiddleElementUsingSimpleForLoop(inputArray);

        System.out.println("Mid Element using Simple Loop= " + midElement);

        midElement = findMiddleElementUsingJava8Loop(inputArray);

        System.out.println("Mid Element using java8 = " + midElement);

    }

    private static int findMiddleElementUsingSimpleForLoop(int[] inputArray) {

        int leftSum, rightSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += inputArray[j];
            }

            rightSum = 0;
            for (int k = i + 1; k < inputArray.length; k++) {
                rightSum += inputArray[k];
            }

            if (leftSum == rightSum)
                return inputArray[i];

        }

        return -1;
    }

    private static int findMiddleElementUsingJava8Loop(int[] inputArray) {

        int leftSum, rightSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            leftSum = 0;

            leftSum = Arrays.stream(inputArray)
                    .boxed()
                    .collect(Collectors.toList())
                    .subList(0, i)
                    .stream()
                    .mapToInt(e -> e)
                    .sum();

            rightSum = 0;
            rightSum = Arrays.stream(inputArray)
                    .boxed()
                    .collect(Collectors.toList())
                    .subList(i + 1, inputArray.length)
                    .stream()
                    .mapToInt(e -> e)
                    .sum();

            if (leftSum == rightSum)
                return inputArray[i];

        }

        return -1;
    }

}
