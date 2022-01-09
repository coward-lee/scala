package org.lee.akka;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.japi.Creator;

public class PropsDemoActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println(message);
    }
    public static Props createProps(){
        return Props.create(new Creator<PropsDemoActor>() {
            @Override
            public PropsDemoActor create() throws Exception, Exception {
                return new PropsDemoActor();
            }
        });
    }
}
