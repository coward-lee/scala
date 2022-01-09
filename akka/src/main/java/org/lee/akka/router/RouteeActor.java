package org.lee.akka.router;

import akka.actor.UntypedAbstractActor;

public class RouteeActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println(getSelf()+"--->"+message+"---->"+getContext().getParent());
    }
}
