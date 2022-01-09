package org.lee.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

public class ForwarderDemo extends UntypedAbstractActor {
    private ActorRef actorRef = getContext().actorOf(PropsDemoActor.createProps());

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println("do forward");
        actorRef.forward(message, getContext());
    }
}
