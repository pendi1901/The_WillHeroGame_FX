package com.example.demo;

public class ParallelizeWork implements Runnable{

    @Override
    public void run() {
        GameResultController.LinkedListSorter.serialize();
    }
}
