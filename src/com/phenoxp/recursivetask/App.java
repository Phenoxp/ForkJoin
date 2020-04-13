package com.phenoxp.recursivetask;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        SimpleRecursiveTask task = new SimpleRecursiveTask(15268);
        System.out.println(pool.invoke(task));
    }
}
