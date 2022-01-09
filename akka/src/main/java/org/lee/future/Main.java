//package org.lee;
//
//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import akka.actor.Props;
//import akka.dispatch.OnComplete;
//import akka.dispatch.OnSuccess;
//import akka.pattern.Patterns;
//import akka.util.Timeout;
//import scala.Function1;
//import scala.concurrent.Future;
//import scala.concurrent.duration.Duration;
//import scala.util.Try;
//
//public class Main {
//    public static void main(String[] args) throws Throwable {
//        ActorSystem system = ActorSystem.create("sys");
//        ActorRef actorRef = system.actorOf(Props.create(ActorDemo.class),"actorDemo");
//        ActorRef actor = system.actorOf(PropsDemoAdapter.createProps(),"propsActor");
//        // 发消息
//        actorRef.tell("hello akka ", ActorRef.noSender());
//
//        ActorRef askActor = system.actorOf(Props.create(AskActorDemo.class,"askActorDemo"));
//        Timeout timeout = new Timeout(Duration.create(2,"seconds"));
//
//        Future<Object> akka_ak = Patterns.ask(askActor, "akka ak", timeout);
//        System.out.println("ask...");
//        akka_ak.onComplete(new OnComplete<Object>() {
//            @Override
//            public void onComplete(Throwable failure, Object success) throws Throwable, Throwable {
//
//            }
//
//            public <A1 extends A, B1> B1 applyOrElse(A1 x, Function1<A1, B1> default$) {
//                return (B1) super.applyOrElse(x, default$);
//            }
//        });
//    }
//}
