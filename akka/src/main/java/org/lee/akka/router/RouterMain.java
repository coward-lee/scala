package org.lee.akka.router;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.sys.Prop;

public class RouterMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef routerTask = system.actorOf(Props.create(RouterTask.class), "routerTask");
        routerTask.tell("helloA", ActorRef.noSender());
        routerTask.tell("helloB", ActorRef.noSender());
        routerTask.tell("helloC", ActorRef.noSender());
    }
}
