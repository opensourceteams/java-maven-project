package com.opensourceteams.modules.common.nio.netty.time.flow.pojo;

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
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    
}
