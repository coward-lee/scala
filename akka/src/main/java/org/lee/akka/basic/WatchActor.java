package org.lee.akka.basic;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

//  停掉一个actor 对应的子级actor的反应
public class WatchActor extends UntypedAbstractActor {
    LoggingAdapter log = Logging.getLogger(this.getContext().system(), this);

    private ActorRef child = null;


    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String){
            if (((String) message).equalsIgnoreCase("stopChild")){
                getContext().stop(child);
                // 解除监控
                getContext().unwatch(child);
            }
        }else if (message instanceof Terminated){
            Terminated t = ((Terminated) message);
            log.info("监控到：【"+ t.getActor()+"】 停止了");
        }else{
            unhandled(message);
        }
    }

    @Override
    public void preStart() throws Exception {

        this.child = getContext().actorOf(Props.create(WorkerActor.class), "watchSubActor");
        getContext().watch(child);
        log.info(" WatchActor start");
    }


    @Override
    public void postStop() throws Exception {
        log.info(" WatchActor stop");
    }

    public static Props createProps(){
        return Props.create(WatchActor.class);
    }
}
