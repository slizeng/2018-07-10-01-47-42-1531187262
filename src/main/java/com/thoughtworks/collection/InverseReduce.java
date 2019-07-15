package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int inputNumber) {
        int stepSize = random.nextInt(3);

        if (stepSize > inputNumber || stepSize == 0) {
            return emptyList();
        }

        List<Integer> result = new ArrayList<>();
        int dividedBoarder = inputNumber / stepSize;
        IntStream.rangeClosed(1, dividedBoarder)
                .boxed()
                .reduce(inputNumber, (a, b) -> {
                    int next = inputNumber - stepSize * b;
                    result.add(next);
                    return next;
                });

        return result;
    }
}
