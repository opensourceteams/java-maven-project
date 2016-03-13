package com.opensourceteams.modules.common.nio.netty.time.flow.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午7:54
 * 功能描述:
 */

public class TimeEncoder extends MessageToByteEncoder<UnixTime> {
    @Override
    protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) {
        out.writeInt((int) msg.value());
    }
}