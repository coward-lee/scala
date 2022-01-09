package org.lee;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.Random;
import java.util.concurrent.*;

public class CompatibleDemo {

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> f = es.submit(()->{
            Thread.sleep(1000);
            return 100;
        });
        Integer integer1 = f.get();
        System.out.println("future get:"+integer1);
//        ListenableFuture<Integer> future = null;
//        future.addListener(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, es);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("completableFuture start");
                Thread.sleep(10000);
                System.out.println("completableFuture end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int i = 1/0;
            return 100;
        });
//future.join();
        Integer integer = completableFuture.get();
        System.out.println("main:"+integer);


        final CompletableFuture<Integer> com = compute();
        class Client extends Thread{
            CompletableFuture<Integer> f;
            Client(String name, CompletableFuture<Integer> f){
                super(name);
                this.f = f;
            }

            @Override
            public void run() {
                try {
                    System.out.println(this.getName()+": start"+f.get());
                    Thread.sleep(1000);
                    System.out.println(this.getName()+":"+f.get());
                }catch (Exception e) {
                    System.out.println("发生异常了");
                }
            }
        }
        System.out.println("main: main: main");
        new Client("client1", com).start();
        new Client("client2", com).start();
        com.complete(100);
        System.out.println("main: main: main");


        // 创建 completable future
        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(() -> ".00");
        CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> ".00", es);
        CompletableFuture<Void> runAsync1 = CompletableFuture.runAsync(() -> System.out.println("do something"));
        CompletableFuture<Void> runAsync2 = CompletableFuture.runAsync(() ->  System.out.println("do something"), es);

//        public CompletableFuture<T> 	whenComplete(BiConsumer<? super T,? super Throwable> action)
//        public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
//        public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
//        public CompletableFuture<T>     exceptionally(Function<Throwable,? extends T> fn)

        // biconsum
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> getMoreData());
        completableFuture1.whenComplete((v,e)->{
            System.out.println("v:"+v);
            System.out.println("e:"+e);
        });
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("completableFuture2  抛出一个异常");
            throw new RuntimeException(" exception test");
        });
        completableFuture2.whenComplete((v,e)->{
            System.out.println("v:"+v);
            System.out.println("e 异常测试:"+e);
        });


        System.out.println(completableFuture1.get());
        Thread.sleep(Integer.MAX_VALUE);

    }
    private static Random rand = new Random();
    private static long temp = System.currentTimeMillis();
    public static int getMoreData(){
        System.out.println("start to compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end to compute");
        return rand.nextInt(1000);
    }
}
