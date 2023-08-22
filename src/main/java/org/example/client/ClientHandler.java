package org.example.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.Packet;


public class ClientHandler extends ChannelInboundHandlerAdapter { // extends ChannelInboundHandlerAdapter can't be missed


    @Override
    public void channelActive(ChannelHandlerContext ctx) { // this function will be called when channel between server and client will be active
        Packet packetOut = new Packet(); // here we initialize our packet.
        // Packet is a custom class with few variables which we can get and set. It's like a box we can put something in. Then this box we will send by channel.
        packetOut.setStringValue("Hello! Square this number! "); // Setting 1-st var
        packetOut.setIntValue(21); // Setting 2-nd var
        ctx.writeAndFlush(packetOut); // here we are sending our packet (box) to the server.


    }


    @Override
    public void channelRead(ChannelHandlerContext cxt, Object msg) throws Exception { // This function will be called when we receive whole packet
        Packet packetIn = (Packet) msg; // here we convert Object msg to our Packet packetIn
        System.out.println("Server response:\n" + packetIn.getStringValue() + packetIn.getIntValue()); // here we print answer from server
    }


}