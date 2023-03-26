package com.coding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateCounting {

    public static Set<Integer> findDuplicateUsingCollectionsFrequencyMethod(List<Integer> inputList) {

        return inputList.stream()
                .filter(e -> Collections.frequency(inputList, e) > 1)
                .collect(Collectors.toSet());

    }

    public static Set<Integer> findDuplicateUsingSet(List<Integer> inputList) {

        Set<Integer> dupSet = new HashSet<>();
        return inputList.stream()
                .filter(e -> !dupSet.add(e))
                .collect(Collectors.toSet());

    }

    public static Set<Integer> findDuplicateUsingGroupBy(List<Integer> inputList) {

        return inputList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                // .peek(e -> System.out.println("**"+ e.getKey()+"--"+e.getValue()))
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    private static Map<String, Long> findDuplicateInString(String inputString) {
        return Stream.of(inputString.split(""))
                // .peek(e->System.out.println(e))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                // .map(Map.Entry::getKey)
  // .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(existing,replacement)-> existing,TreeMap::new));
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public static void main(String[] args) {
        List<Integer> inputList = List.of(5, 13, 4,
                21, 13, 27,
                2, 59, 59, 34);
        System.out.println("*******find Duplicate Using Collections.Frequency() Method*******");

        findDuplicateUsingCollectionsFrequencyMethod(inputList).forEach(System.out::println);

        System.out.println("*******find Duplicate Using filter (e-> !set.add(e)) *******");

        findDuplicateUsingSet(inputList).forEach(System.out::println);

        System.out.println(
                "*******find Duplicate Using collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) *******");

        findDuplicateUsingGroupBy(inputList).forEach(System.out::println);

        System.out.println("*******Count the distinct duplicate char with its count in alphaNemeric string *******");

        findDuplicateInString("Indivisibilities")
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + "--" + e.getValue()));

    }

}
