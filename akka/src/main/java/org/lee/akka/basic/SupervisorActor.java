package org.lee.akka.basic;

import akka.actor.*;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.io.IOException;
import java.sql.SQLException;

// 自定义策略
public class SupervisorActor extends UntypedAbstractActor {

    private SupervisorStrategy strategy = new OneForOneStrategy(3,
            Duration.create("1 minute"), new Function<Throwable, SupervisorStrategy.Directive>(){
        @Override
        public SupervisorStrategy.Directive apply(Throwable param) throws Exception, Exception {
            if (param instanceof IOException){
                System.out.println("======ioe========");
                return (SupervisorStrategy.Directive) SupervisorStrategy.resume();
            }else if (param instanceof IndexOutOfBoundsException){
                System.out.println("IndexOutOfBoundsException");
                return ((SupervisorStrategy.Directive) SupervisorStrategy.restart());
            }else if (param instanceof SQLException){
                return ((SupervisorStrategy.Directive) SupervisorStrategy.stop());
            }else{
                return ((SupervisorStrategy.Directive) SupervisorStrategy.escalate());
            }
        }
    });
    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }
    ActorRef actorRef = null;

    @Override
    public void preStart() throws Exception {
        actorRef = getContext().actorOf(Props.create(WorkerActor.class), "superviseeWorkerActor");
        getContext().watch(actorRef);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof Terminated){
            Terminated terminated = (Terminated) message;
            System.out.println(terminated.actor()+" 已经停止了");
        }else{
            System.out.println("supervisor message :"+message);
            actorRef.tell(message, self());
        }
    }

}
