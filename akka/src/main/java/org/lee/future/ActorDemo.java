package org.lee.future;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ActorDemo extends UntypedAbstractActor {
    private LoggingAdapter log = Logging.getLogger(this.getContext().system(),this);
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String){
            log.info(message.toString());
        }
    }
}

