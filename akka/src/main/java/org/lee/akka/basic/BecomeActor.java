package org.lee.akka;

import akka.actor.UntypedAbstractActor;

public class BecomeActor extends UntypedAbstractActor {


    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println("接受到消息："+ message);
//        getContext().become(new );
        System.out.println("================BecomeActor==================");
    }
}
