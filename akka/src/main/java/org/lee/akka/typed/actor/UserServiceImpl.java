package org.lee.akka.typed.actor;

import scala.Option;
import scala.concurrent.Future;

public interface UserService {
    void saveUser(String id, String user);
    Future<String> findUserForFuture(String id);
    Option<String> findUserForOpt(String id);
    String findUser(String id);
}
