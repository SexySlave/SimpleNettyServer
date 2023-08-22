package org.example.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.Packet;

import java.net.InetSocketAddress;


public class ServerHandler extends ChannelInboundHandlerAdapter { // extends ChannelInboundHandlerAdapter can't be missed
    @Override
    public void channelActive(ChannelHandlerContext ctx) { // this function will be called when channel between server and client will be active
        InetSocketAddress remoteAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = remoteAddress.getAddress().getHostAddress();
        System.out.println(ip);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // This function will be called when we receive whole packet
        if (msg instanceof Packet) { // checking if the Object instance of Packet class. If you sure that msg instance of your class you can run your code without checking.
            Packet packetSIn = (Packet) msg; // here we convert Object msg to our Packet packetIn
            System.out.println("Client request:\n" + packetSIn.getStringValue() + packetSIn.getIntValue());
            Packet packetSOut = new Packet(); // initialize new Packet for response
            packetSOut.setStringValue("Here is youre number: ");
            packetSOut.setIntValue(packetSIn.getIntValue() * packetSIn.getIntValue());
            ctx.writeAndFlush(packetSOut); // here we are sending our packet to the client.
        }


    }

}
