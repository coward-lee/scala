package org.lee.akka;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.Option;

import java.io.IOException;
import java.sql.SQLException;

public class WorkerActor extends UntypedAbstractActor {
    LoggingAdapter log = Logging.getLogger(this.getContext().system(), this);
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        log.info("worker actor收到了消息："+message);
        if ("io".equalsIgnoreCase(message.toString())){
            throw new IOException("ioe");
        }
        if ("sql".equalsIgnoreCase(message.toString())){
            throw new SQLException("sqle");
        }
        if ("index".equalsIgnoreCase(message.toString())){
            throw new IndexOutOfBoundsException("index");
        }
    }

    @Override
    public void preStart() throws Exception {
        log.info("worker 启动了");
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        log.info("worker 重启了");
    }


    @Override
    public void postRestart(Throwable reason) throws Exception {
        log.info("worker 重启了");
    }

    @Override
    public void postStop() throws Exception {
        log.info("worker 被停职了");
        super.postStop();
    }

    public static Props createProps(){
        return Props.create(WorkerActor.class);
    }
}
