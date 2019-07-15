package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Double.valueOf;
import static org.apache.commons.collections.CollectionUtils.isEmpty;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        Optional<Integer> optionalResult = arrayList.stream().max(Comparator.comparingInt(a -> a));
        if (optionalResult.isPresent()) {
            return optionalResult.get();
        } else throw new NoSuchElementException();
    }

    public double getMinimum() {
        Optional<Integer> optionalResult = arrayList.stream().min(Comparator.comparingInt(a -> a));
        if (optionalResult.isPresent()) {
            return optionalResult.get();
        } else throw new NoSuchElementException();
    }

    public double getAverage() {
        return arrayList.stream().collect(Collectors.averagingInt(a -> (int) a));
    }

    public double getOrderedMedian() {
        if (isEmpty(arrayList)) {
            throw new NoSuchElementException();
        }

        int size = arrayList.size();
        if (size % 2 == 0) {
            return (double) (arrayList.get(size / 2 - 1) + arrayList.get(size / 2)) / 2;
        } else {
            return arrayList.get(size / 2);
        }
    }

    public int getFirstEven() {
        Optional<Integer> optionalResult = arrayList.stream()
                .filter(element -> element % 2 == 0)
                .findFirst();

        if (optionalResult.isPresent()) {
            return optionalResult.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    public int getIndexOfFirstEven() {
        OptionalInt optionalResult = IntStream.range(0, arrayList.size())
                .filter(index -> arrayList.get(index) % 2 == 0)
                .findFirst();

        if (optionalResult.isPresent()) {
            return optionalResult.getAsInt();
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.toString().equals(this.arrayList.toString());
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int arraySize = arrayList.size();
        if (arraySize % 2 == 0) {
            return (double) ((Integer) singleLink.getNode(arraySize / 2)
                    + (Integer) singleLink.getNode(arraySize / 2 + 1)) / 2;
        }

        return valueOf(singleLink.getNode(arraySize / 2 + 1).toString());
    }

    public int getLastOdd() {
        Optional<Integer> optionalResult = arrayList.stream()
                .filter(element -> element % 2 == 1)
                .reduce((a, b) -> b);

        if (optionalResult.isPresent()) {
            return optionalResult.get();
        } else throw new NoSuchElementException();
    }

    public int getIndexOfLastOdd() {
        Optional<Integer> optionalResult = IntStream.range(0, arrayList.size())
                .boxed()
                .filter(index -> arrayList.get(index) % 2 == 1)
                .reduce((a, b) -> b);

        if (optionalResult.isPresent()) {
            return optionalResult.get();
        } else throw new NoSuchElementException();
    }
}
