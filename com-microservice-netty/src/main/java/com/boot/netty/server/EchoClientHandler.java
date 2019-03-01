package com.boot.netty.server;

import org.springframework.stereotype.Service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

@Service("echoClientHandler")
public class EchoClientHandler extends ChannelInboundHandlerAdapter
{
    /**
     * 此方法会在连接到服务器后被调用
     */
    public void channelActive(ChannelHandlerContext ctx)
    {
        ctx.write(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    /**
     * 业务逻辑处理
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        // 如果不是protobuf类型的数据
        if (!(msg instanceof ByteBuf))
        {
            System.out.println("未知数据!" + msg);
            return;
        }
        try
        {
            ByteBuf in = (ByteBuf) msg;
            System.out.println("Client received: " +
                    ByteBufUtil.hexDump(in.readBytes(in.readableBytes())));
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            ReferenceCountUtil.release(msg);
        }
    }
    /**
     * 捕捉到异常
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    {
        cause.printStackTrace();
        ctx.close();
    }
}