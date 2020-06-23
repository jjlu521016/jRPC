package io.jjlu.jrpc.message;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * 消息解码器
 */
public interface MessageCodec {

    void encode(final ByteBuf out, final Object message) throws IOException;

    Object decode(byte[] body) throws IOException;
}
