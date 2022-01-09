package org.lee.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class CreateActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        // 创建actor
        getContext().actorOf(Props.create(ChildActor.class, "childActor"));
        return null;
    }

}
class ChildActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        return null;
    }
}
