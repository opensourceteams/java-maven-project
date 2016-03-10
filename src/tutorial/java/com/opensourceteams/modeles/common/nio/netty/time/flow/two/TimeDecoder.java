package com.opensourceteams.modeles.common.nio.netty.time.flow.two;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午7:12
 * 功能描述:，基于流的传输并不是一个数据包队列，而是一个字节队列。即使你发送了2个独立的数据包，操作系统也不会作为2个消息处理而仅仅是作为一连串的字节而言。
 */

public class TimeDecoder extends ByteToMessageDecoder { // (1)

    /**
     * 先不处理，等到一定量的数据再处理
     * @param ctx
     * @param in
     * @param out
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        if (in.readableBytes() < 4) {
            return; // (3)
        }

        out.add(in.readBytes(4)); // (4)
    }
}
