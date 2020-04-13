package com.phenoxp.maxfinding;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer> {
    private int[] nums;
    private int lowIndex;
    private int highIndex;

    public ParallelMaxFinding(int[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if (highIndex - lowIndex < AppForMax.THRESHOLD) {
            return sequentialFindMax();
        } else {
            int middleIndex = (lowIndex + highIndex) / 2;

            ParallelMaxFinding task1 = new ParallelMaxFinding(nums, lowIndex, middleIndex);
            ParallelMaxFinding task2 = new ParallelMaxFinding(nums, middleIndex + 1, highIndex);

            invokeAll(task1, task2);

            return Math.max(task1.join(), task2.join());
        }
    }

    private int sequentialFindMax() {
        int max = nums[lowIndex];

        for (int i = lowIndex; i < highIndex; i++) {
            if (nums[i] > max)
                max = nums[i];
        }

        return max;
    }
}
