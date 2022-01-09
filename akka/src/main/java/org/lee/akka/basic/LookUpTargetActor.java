package org.lee.akka.basic;

import akka.actor.UntypedAbstractActor;

public class LookUpTargetActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println(" target ："+message);
    }
}
