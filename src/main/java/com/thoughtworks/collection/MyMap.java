package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map(element -> element * 3)
                .collect(toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .map(this::mapSingleLetter)
                .collect(toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(this::mapMultiplyLetter)
                .collect(toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream()
                .sorted(Comparator.comparingInt(number -> 0 - number))
                .collect(toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream()
                .sorted(Comparator.comparingInt(number -> number))
                .collect(toList());
    }

    private String mapMultiplyLetter(int number) {
        int poolSize = letters.length;

        int primaryIndex = number / poolSize;
        int secondaryIndex = number % poolSize;

        if (secondaryIndex == 0) {
            primaryIndex = primaryIndex - 1;
            secondaryIndex = poolSize;
        }

        return mapSingleLetter(primaryIndex).concat(
                mapSingleLetter(secondaryIndex)
        );
    }

    private String mapSingleLetter(int number) {
        return number > 0 ? letters[number - 1] : "";
    }
}
