package com.boot.netty.server;

import org.springframework.stereotype.Service;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

@Service("echoServerHandler")
public class EchoServerHandler extends ChannelInboundHandlerAdapter
{

    /**
     * 建立连接时，发送一条消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        super.channelActive(ctx);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg)
    {
        try
        {
            System.out.println("server received data :" + msg);
            ctx.write(msg);//写回数据，

        } finally
        {
            ReferenceCountUtil.release(msg);
        }
    }

    public void channelReadComplete(ChannelHandlerContext ctx)
    {
        //flush掉所有写回的数据
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE); //当flush完成后关闭channel
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    {
        //捕捉异常信息
        cause.printStackTrace();
        //出现异常时关闭channel
        ctx.close();
    }
}