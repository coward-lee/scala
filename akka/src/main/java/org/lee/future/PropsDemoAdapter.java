package org.lee.future;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.japi.Creator;

public class PropsDemoAdapter extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {

    }
    public static Props createProps(){
        return Props.create(new Creator<Actor>() {
            @Override
            public Actor create() throws Exception, Exception {
                return new PropsDemoAdapter();
            }
        });
    }
}
