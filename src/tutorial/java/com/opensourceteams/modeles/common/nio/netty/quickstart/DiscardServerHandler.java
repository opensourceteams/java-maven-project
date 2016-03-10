package com.opensourceteams.modeles.common.nio.netty.quickstart;

import io.netty.buffer.ByteBuf;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午6:09
 * 功能描述: Handles a server-side channel.
 */

public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException { // (2)
/*        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }*/
        String message = getMessage(msg);
        ctx.write(getSendByteBuf("返回的信息:" +  message)); // (1)

        System.out.println("服务器接收到消息:" + msg);
        System.out.println("服务器接收到消息:" + message);
        ctx.flush(); // (2)
    }
    /*
     * 从ByteBuf中获取信息 使用UTF-8编码返回
     */
    private String getMessage(ByteBuf buf) {

        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    private String getMessage(Object object) {
        ByteBuf buf = (ByteBuf)object;
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ByteBuf getSendByteBuf(String message)
            throws UnsupportedEncodingException {

        byte[] req = message.getBytes("UTF-8");
        ByteBuf pingMessage = Unpooled.buffer();
        pingMessage.writeBytes(req);

        return pingMessage;
    }

}