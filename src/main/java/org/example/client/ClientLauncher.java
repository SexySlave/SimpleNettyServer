package org.example.client;

public class ClientLauncher {
    public static void main(String[] args) throws Exception {
        //here we just initialize our NettyClient class and start client
        NettyClient nettyClient = new NettyClient();
        nettyClient.run();
    }
}
