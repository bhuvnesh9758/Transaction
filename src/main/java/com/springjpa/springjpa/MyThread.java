package com.springjpa.springjpa;

import java.util.concurrent.*;

class MyThread extends Thread{
    private TopicService topicService;
    ExecutorService exec;
    public synchronized void run() {
        try{
            exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Topic topic=new Topic("hello","hello","hello");
            topicService.add(topic);
            exec.shutdown();
            System.out.println(Thread.currentThread().getName() + "inserted data");
        }catch (Exception e){
            System.out.println("exception caught");
        }
    }
//    public void run (){
//
//
//        do {
//            ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//            Future<Integer> future = exec.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    long newVar = (long)(Math.random()*100);
//                    int var = (int)(newVar);
//                    try {
//                        Thread.sleep(newVar);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    return var;
//
//                }
//
//            });
//
//            exec.shutdown();
//            try {
////                System.out.println(future.get());
//                Topic topic = new Topic("hello", "hello", "hello");
//                topicService.add(topic);
//                System.out.println(Thread.currentThread().getName() + "inserted data");
////
////                if (future.get() == 10) {
////                    System.out.println("10 generated !!\n");
////                    break;
//            }catch(Exception e){
//                System.out.println("exception caught");
//            }
////
//        } while(true);
//    }
}

//public class Main{
//    public static void main(String[] args){
//
//        MyThread obj1 = new MyThread();
//        MyThread obj2 = new MyThread();
//        MyThread obj3 = new MyThread();
//
//
//        obj1.start();
//        obj2.start();
//        obj3.start();
//
//
//    }
//}