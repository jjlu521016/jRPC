package io.jjlu.jrpc.serialization.protobuf;

import io.jjlu.jrpc.serialization.RpcSerialize;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * protobuf序列化实现类
 */
public class ProtobufSerialize implements RpcSerialize {

    @Override
    public void serialize(OutputStream output, Object object) throws IOException {

    }

    @Override
    public Object deserialize(InputStream input) throws IOException {
        return null;
    }
}
