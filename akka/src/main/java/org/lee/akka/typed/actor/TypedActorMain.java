package org.lee.akka.typed.actor;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedActorExtension;
import akka.actor.TypedProps;
import akka.dispatch.OnComplete;
import akka.japi.Creator;
import akka.japi.Option;
import scala.Function1;
import scala.concurrent.Future;

public class TypedActorMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        TypedActorExtension typedActorExtension = TypedActor.get(system);
        UserService userService = typedActorExtension.typedActorOf(new TypedProps<UserServiceImpl>(UserService.class, UserServiceImpl.class));
        userService.saveUser("1", "user1");
        userService.saveUser("2", "user2");
        userService.saveUser("3", "user3");
        Future<String> userForFuture = userService.findUserForFuture("1");
        userForFuture.onComplete(new OnComplete<String>() {
            @Override
            public void onComplete(Throwable failure, String success) throws Throwable, Throwable {
                if (failure != null){
                    System.out.println("userForFuture 失败了");
                }
                if (success != null){
                    System.out.println("userForFuture 成功了："+success);
                }
            }
        }, system.dispatcher());
        Option<String> userForOpt = userService.findUserForOpt("2");
        if (!userForOpt.isEmpty()){
            System.out.println("userForOpt:"+userForOpt.get());
        }
        System.out.println("user:"+userService.findUser("3"));
    }

    TypedProps<UserServiceImpl> typedProps  = new TypedProps<UserServiceImpl>(UserService.class, new Creator<UserServiceImpl>() {
        @Override
        public UserServiceImpl create() throws Exception, Exception {
            return new UserServiceImpl();
        }
    });

}
