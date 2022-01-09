package org.lee.akka.basic;

import akka.actor.*;

import java.util.Optional;

public class LookupActor extends UntypedAbstractActor {
    private ActorRef target = null;

    public LookupActor() {
        target = getContext().actorOf(Props.create(LookUpTargetActor.class),"LookUpTargetActor");
    }


    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String){
            if ("find".equalsIgnoreCase(message.toString())){
                ActorSelection selection = getContext().actorSelection("LookUpTargetActor");
                selection.tell(new Identify("A0001"), self());
            }
        }else if (message instanceof ActorIdentity){
            ActorIdentity ai = (ActorIdentity) message;
            Optional<ActorRef> actorRef = ai.getActorRef();
            if (actorRef.isPresent()){
                System.out.println("actor identity:"+ai.correlationId()+" "+actorRef);
                actorRef.get().tell("hello  target", getSelf());
            }
        }else{
            unhandled(message);
        }
    }
}
