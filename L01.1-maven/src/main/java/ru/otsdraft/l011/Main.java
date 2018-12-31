package ru.otsdraft.l011;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final int MEASURE_COUNT = 1;

    public static void main(String[] args) {
        List<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 999_999;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }
        List<Integer> result = new ArrayList<>();
        Collections.shuffle(example);
        calcTime(() -> result.addAll(Lists.reverse(example)));
        System.out.println("result.size() = " + result.size());
    }

    private static void calcTime(Runnable runnable) {
        long start = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++) {
            runnable.run();
        }
        long finish = System.nanoTime();
        long time = (finish - start) / MEASURE_COUNT;
        System.out.println("Time spend: " + time + "ns (" + time / 1_000_000 + "ms)");
    }
}
