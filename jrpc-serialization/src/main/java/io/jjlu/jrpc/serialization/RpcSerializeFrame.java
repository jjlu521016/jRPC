package io.jjlu.jrpc.serialization;

import io.jjlu.jrpc.serialization.enums.RpcSerializeProtocol;
import io.netty.channel.ChannelPipeline;

/**
 * RPC消息序序列化协议选择器接口
 */
public interface RpcSerializeFrame {

    /**
     * rpc协议选择
     *
     * @param protocol 协议
     * @param pipeline pipeline
     */
    void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline);
}
