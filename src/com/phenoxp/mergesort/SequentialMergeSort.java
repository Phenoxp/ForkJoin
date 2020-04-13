package com.phenoxp.mergesort;

import java.util.Arrays;

public class SequentialMergeSort {

    public void mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int middle = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle + 1, nums.length);

        mergeSort(left);
        mergeSort(right  );
        merge(left, right, nums);
    }

    private void merge(int [] left, int[] right, int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;

        while ((i < left.length) && (j < right.length)) {
            if (left[i] < right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while (i < left.length) {
            nums[k++] = left[i++];
        }

        while (j < right.length) {
            nums[k++] = right[j++];
        }
    }
}
