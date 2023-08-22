package org.example.server;
public class ServerLauncher {
    public static void main(String[] args) throws Exception {
        // here we just initialize our NettyServer class and start server
        NettyServer nettyServer = new NettyServer();
        nettyServer.run();
    }
}
