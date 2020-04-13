package com.phenoxp.recursiveaction;

import java.util.concurrent.ForkJoinPool;

public class Application {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(620);
        pool.invoke(simpleRecursiveAction);
    }
}
