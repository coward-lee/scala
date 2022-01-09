package org.lee.akka.basic;

import akka.actor.*;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class Main {
    public static void main(String[] args) {
        Timeout timeout = new Timeout(Duration.create(2, "seconds"));
        ActorSystem system = ActorSystem.create("cmb");
        // 创建actor
        ActorRef actorRef = system.actorOf(PropsDemoActor.createProps());
        Future<Object> akka_ask = Patterns.ask(actorRef, "akka ask", timeout);
        akka_ask.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable failure, Object success) throws Throwable, Throwable {
                System.out.println("消息回调, f:"+failure+""+success);
            }
        },system.dispatcher());
        // forward 消息转发
        ActorRef forward = system.actorOf(Props.create(ForwarderDemo.class));
        forward.tell("a forward message", ActorRef.noSender());
        // 查找actor
//        ActorSelection selection = [ActorSystem/ ActorContext]
        // actorSelection([path]);

        ActorRef lookupActor = system.actorOf(Props.create(LookupActor.class),"lookupActor");
        System.out.println("lookupActor demo ==================================");
        lookupActor.tell("find", ActorRef.noSender());

        // 查看是否超时,使用回调来查看
        ActorSelection actorSelection = system.actorSelection("akka://cmb/user/lookupActor/LookUpTargetActor");
        Future<ActorRef> actorRefFuture = actorSelection.resolveOne(timeout);
        actorRefFuture.onComplete(new OnComplete<ActorRef>() {
            @Override
            public void onComplete(Throwable failure, ActorRef success) throws Throwable, Throwable {
                if (failure!=null){
                    System.out.println("查找失败了");
                    return;
                }
                if (success != null) {
                    System.out.println("查找成功了:"+ success.path());
                }
            }
        }, system.dispatcher());

        // actor 行为切换
        // 停掉一个actor
//        ActorRef stopDemoActor = system.actorOf(WorkerActor.createProps(), "stopDemoActor");
//        system.stop(stopDemoActor);
//        stopDemoActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
//        stopDemoActor.tell(Kill.getInstance(), ActorRef.noSender());

        ActorRef watchActor = system.actorOf(WatchActor.createProps(), "watchActor");
        watchActor.tell("stopChild", ActorRef.noSender());


        ActorRef supervisorActor = system.actorOf(Props.create(SupervisorActor.class),"SupervisorActor");
        supervisorActor.tell("io", ActorRef.noSender());
        supervisorActor.tell("index", ActorRef.noSender());
        supervisorActor.tell("sql", ActorRef.noSender());
    }
}
