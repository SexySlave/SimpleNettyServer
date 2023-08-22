package org.example.client;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
public class NettyClient {
    public void run() throws Exception {
        String host = "localhost"; // there should be a server IP
        int port = 8080; // there is server port


        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ObjectEncoder(), // there is an ObjectEncoder. You can put your own ObjectEncoder. Now we use standard ObjectEncoder.
                            new ObjectDecoder(ClassResolvers.cacheDisabled(null)), // there is an ObjectDecoder. You can put your own ObjectDecoder. Now we use standard ObjectDecoder.
                            new ClientHandler()); // there is a ClientHandler. Here you should put your own ClientHandler. In this case we use ClientHandler class, it is our custom class.

                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            workerGroup.shutdownGracefully();
        }

    }


}