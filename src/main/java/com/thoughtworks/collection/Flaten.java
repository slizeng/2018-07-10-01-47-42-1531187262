package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimensional() {
        return Arrays.stream(array).flatMap(Arrays::stream).collect(toList());
    }

    public List<Integer> transformToUnrepeatedOneDimensional() {
        return transformToOneDimensional().stream().distinct().collect(toList());
    }
}
