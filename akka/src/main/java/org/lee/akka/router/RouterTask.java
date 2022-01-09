package org.lee.akka.router;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;

import java.util.ArrayList;
import java.util.List;

public class RouterTask extends UntypedAbstractActor {

    private Router router;

    @Override
    public void preStart() throws Exception {
        List<Routee> routeeList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ActorRef actorRef = getContext().actorOf(Props.create(RouteeActor.class), "routeeActor" + i);
            ActorRefRoutee actorRefRoutee = new ActorRefRoutee(actorRef);
            routeeList.add(actorRefRoutee);
        }
        router = new Router(new RoundRobinRoutingLogic(), routeeList);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        router.route(message, getSender());
    }
}
