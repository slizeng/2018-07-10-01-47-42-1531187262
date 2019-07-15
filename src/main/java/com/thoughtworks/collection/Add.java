package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.sun.tools.javac.util.List.of;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.*;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> borders = orderBorders(leftBorder, rightBorder);

        return IntStream.rangeClosed(borders.get(0), borders.get(1))
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> borders = orderBorders(leftBorder, rightBorder);

        return IntStream.rangeClosed(borders.get(0), borders.get(1))
                .filter(number -> number % 2 == 1)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(number -> number * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number -> number % 2 == 0 ? number : number * 3 + 2)
                .collect(toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 1)
                .mapToInt(number -> number * 3 + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evens = arrayList.stream().filter(number -> number % 2 == 0).collect(toList());
        int arraySize = evens.size();
        int index = arraySize % 2 == 0 ? arraySize / 2 - 1 : arraySize / 2;
        return evens.get(index);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .collect(averagingDouble(a -> a));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .anyMatch(element -> element.equals(specialElement));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Map<Boolean, List<Integer>> evenAndOddMap = arrayList.stream().collect(partitioningBy(element -> element % 2 == 0));

        List<Integer> sortedEvens = evenAndOddMap.get(true).stream()
                .sorted(Comparator.comparingInt(a -> a))
                .collect(toList());
        List<Integer> sortedOdds = evenAndOddMap.get(false).stream()
                .sorted(Comparator.comparingInt(a -> 0 - a))
                .collect(toList());

        return Stream.of(sortedEvens, sortedOdds).flatMap(Collection::stream).collect(toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        Integer previousValue = null;

        return null;
    }

    public static List<Integer> orderBorders(int firstBorder, int secondBorder) {
        int startBorder = firstBorder < secondBorder ? firstBorder : secondBorder;
        int endBorder = firstBorder < secondBorder ? secondBorder : firstBorder;

        return of(startBorder, endBorder);
    }
}
