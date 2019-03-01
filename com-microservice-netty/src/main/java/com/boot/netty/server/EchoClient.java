package com.boot.netty.server;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

@Service("EchoClient")
public class EchoClient
{
    // 服务器ip地址
    @Value("${server.ip}")
    private String host;
    // 服务器端口
    @Value("${server.port}")
    private int port;

    // 通过nio方式来接收连接和处理连接
    private EventLoopGroup group = new NioEventLoopGroup();

    @Autowired
    private EchoClientHandler echoClientHandler;

    /**
     * 唯一标记
     */
    private boolean initFalg = true;

    /**
     * 客户端的是Bootstrap，服务端的则是 ServerBootstrap。
     * 都是AbstractBootstrap的子类。
     **/
    public void run()
    {
        doConnect(new Bootstrap(), group);
    }

    /**
     * 重连
     */
    public void doConnect(Bootstrap bootstrap, EventLoopGroup eventLoopGroup)
    {
        ChannelFuture f = null;
        try
        {
            if (bootstrap != null)
            {
                bootstrap.group(eventLoopGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
                bootstrap.remoteAddress(host, port);

                // 设置通道初始化
                bootstrap.handler(
                        new ChannelInitializer<SocketChannel>()
                        {
                            public void initChannel(SocketChannel ch) throws Exception
                            {
                                ch.pipeline().addLast(echoClientHandler);
                            }
                        }
                );
                f = bootstrap.connect().addListener((ChannelFuture futureListener) ->
                {
                    final EventLoop eventLoop = futureListener.channel().eventLoop();
                    if (!futureListener.isSuccess())
                    {
                        System.out.println("与服务端断开连接!在10s之后准备尝试重连!");
                        eventLoop.schedule(() -> doConnect(new Bootstrap(), eventLoop), 10, TimeUnit.SECONDS);
                    }
                });
                if (initFalg)
                {
                    System.out.println("EchoClient客户端连接成功!");
                    initFalg = false;
                }
                // 阻塞
                f.channel().closeFuture().sync();
            }
        } catch (Exception e)
        {
            System.out.println("客户端连接失败!" + e.getMessage());
        }

    }
}