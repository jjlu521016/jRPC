package io.jjlu.jrpc.message;

import io.jjlu.jrpc.core.constant.RpcConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {

    public static final Logger log = LoggerFactory.getLogger(MessageDecoder.class);

    private MessageCodec codec = null;

    public MessageDecoder(MessageCodec codec) {
        this.codec = codec;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        //内容小于指定长度，舍弃
        if (byteBuf.readableBytes() < RpcConfig.MESSAGE_LENGTH) {
            return;
        }
        byteBuf.markReaderIndex();
        int messageLength = byteBuf.readInt();
        if (messageLength < 0) {
            ctx.close();
        }

        if (byteBuf.readableBytes() < messageLength) {
            byteBuf.resetReaderIndex();
        } else {
            byte[] messageBody = new byte[messageLength];
            byteBuf.readBytes(messageBody);
            try {
                Object obj = codec.decode(messageBody);
                out.add(obj);
            } catch (IOException ex) {
                log.error("解析数据异常{}", ex.getMessage());
            }
        }
    }
}
