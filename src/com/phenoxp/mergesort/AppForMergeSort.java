package com.phenoxp.mergesort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class AppForMergeSort {

    private static final int LEN = 100000000;

    public static void main(String[] args) {
        int[] nums = initializeNums();
        int processors = Runtime.getRuntime().availableProcessors();


        SequentialMergeSort sequentialMergeSort = new SequentialMergeSort();
        long start = System.currentTimeMillis();
        sequentialMergeSort.mergeSort(nums);
        System.out.println("Sequential algorithm: " + (System.currentTimeMillis() - start) + "ms");

        ForkJoinPool pool = new ForkJoinPool(processors);
        ParallelMergeSortAction parallelMergeSortAction = new ParallelMergeSortAction(nums);
        start = System.currentTimeMillis();
        pool.invoke(parallelMergeSortAction);
        System.out.println("Parallel algorithm: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int[] initializeNums() {
        Random random = new Random();
        int[] nums = new int[LEN];
        for (int i = 0; i < LEN; i++)
            nums[i] = random.nextInt(LEN);

        return nums;
    }
}
