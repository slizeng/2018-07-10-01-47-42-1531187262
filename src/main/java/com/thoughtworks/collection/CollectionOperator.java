package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static com.thoughtworks.collection.Add.orderBorders;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections.CollectionUtils.addAll;

public class CollectionOperator {
    private static boolean isDescending(int startValue, int endValue) {
        return startValue > endValue;
    }

    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> borders = orderBorders(left, right);
        List<Integer> increasingResult = IntStream.rangeClosed(borders.get(0), borders.get(1))
                .boxed()
                .collect(toList());

        return isDescending(left, right) ?
                increasingResult.stream().sorted(reverseOrder()).collect(toList()) :
                increasingResult;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream()
                .filter(element -> element % 2 == 0)
                .collect(toList());
    }

    public List<Integer> popEvenElements(int[] array) {
        return Arrays.stream(array).filter(element -> element % 2 == 0).boxed().collect(toList());
    }

    public int popLastElement(int[] array) {
        OptionalInt lastElement = Arrays.stream(array).reduce((a, b) -> b);
        if (lastElement.isPresent()) {
            return lastElement.getAsInt();
        } else throw new NoSuchElementException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> secondArrayList = Arrays.stream(secondArray).boxed().collect(toList());

        return Arrays.stream(firstArray)
                .filter(secondArrayList::contains)
                .boxed()
                .collect(toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> totalArray = Arrays.stream(firstArray).collect(toList());
        addAll(totalArray, secondArray);

        return totalArray.stream().distinct().collect(toList());
    }
}
