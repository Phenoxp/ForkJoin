package com.phenoxp.recursiveaction;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        if (simulatedWork > 100) {
            System.out.println("Parallel execution and split task... " + simulatedWork);

            SimpleRecursiveAction recursiveAction1 = new SimpleRecursiveAction(simulatedWork / 2);
            SimpleRecursiveAction recursiveAction2 = new SimpleRecursiveAction(simulatedWork / 2);

            recursiveAction1.fork();
            recursiveAction2.fork();
            invokeAll(recursiveAction1, recursiveAction2);
        } else {
            System.out.println("No need for paralell execution, sequential is Ok " + simulatedWork);
        }
    }
}
