package org.lee;

import akka.actor.UntypedAbstractActor;

public class AskActorDemo extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        getSender().tell("hello "+message, getSelf());
    }
}
