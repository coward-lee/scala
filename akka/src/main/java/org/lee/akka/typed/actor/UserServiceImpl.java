package org.lee.akka.typed.actor;

import akka.dispatch.Futures;
import akka.japi.Option;
import scala.concurrent.Future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService {
    private static Map<String, String> map = new ConcurrentHashMap<>();
    @Override
    public void saveUser(String id, String user){
        map.put(id, user);
    }
    @Override
    public Future<String> findUserForFuture(String id){
        return Futures.successful(map.get(id));
    }
    @Override
    public Option<String> findUserForOpt(String id){
        return Option.some(map.get(id));
    }
    @Override
    public String findUser(String id){
        return map.get(id);
    }
}
