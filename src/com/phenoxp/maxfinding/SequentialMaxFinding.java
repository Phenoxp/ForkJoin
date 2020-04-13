package com.phenoxp.maxfinding;

public class SequentialMaxFinding {

    //O(n)
    public int sequentialMaxFind(int [] nums, int highIndex){
        int max = nums[0];

        for(int i=0; i<highIndex; i++){
            if( nums[i]>max)
                max = nums[i];
        }
        return max;
    }
}
