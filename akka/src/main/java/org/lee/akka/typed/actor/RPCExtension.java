package org.lee.akka.typed.actor;

import akka.actor.Extension;

public class RPCExtension implements Extension {
    private String server;
    private Integer port;

    public RPCExtension(String server, Integer port) {
        this.server = server;
        this.port = port;
    }

    public void rpcCall(String cmb){
        System.out.println("cmb : " + cmb);
    }
}
