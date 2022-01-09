package org.lee.akka.router;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.routing.RoundRobinPool;

public class MasterRouterActor extends UntypedAbstractActor {

    ActorRef router = null;

    @Override
    public void preStart() throws Exception {
        router = getContext().actorOf(new RoundRobinPool(3).props(Props.create(RouteeActor.class)), "taskActor");
        System.out.println("router:"+router);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        router.tell(message, getSender());
    }
}
