package com.opensourceteams.modeles.common.nio.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午6:44
 * 功能描述:时间服务器
 */

public class TimeServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
        ChannelFuture channelFuture = f.addListener(new ChannelFutureListener() {

            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        });// (4)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    
}
