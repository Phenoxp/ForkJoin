package com.phenoxp.maxfinding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class AppForMax {
    public static final Integer LEN = 1000000;
    public static Integer THRESHOLD = 123;

    public static void main(String[] args) {
        int[] nums = initializeNums();
        int processors = Runtime.getRuntime().availableProcessors();

        THRESHOLD = LEN / processors;

        SequentialMaxFinding sequentialMaxFinding = new SequentialMaxFinding();

        long start = System.currentTimeMillis();
        System.out.println("Max: " + sequentialMaxFinding.sequentialMaxFind(nums, LEN));
        System.out.println("Time taken by Sequential approach: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        ForkJoinPool pool = new ForkJoinPool(processors);
        ParallelMaxFinding parallelMaxFinding = new ParallelMaxFinding(nums, 0, LEN);

        start = System.currentTimeMillis();
        System.out.println("Max: " + pool.invoke(parallelMaxFinding));
        System.out.println("Time taken by Parallel approach: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int[] initializeNums() {
        Random random = new Random();

        int[] nums = new int[LEN];
        for (int i = 0; i < LEN; i++)
            nums[i] = random.nextInt(LEN);

        return nums;
    }

}
