package io.jjlu.jrpc.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 序列化接口
 */
public interface RpcSerialize {

    /**
     * 序列化
     *
     * @param output 数据流
     * @param object 序列化的对象
     * @throws IOException 异常
     */
    void serialize(OutputStream output, Object object) throws IOException;

    /**
     * 反序列化
     *
     * @param input 数据流
     * @return 反序列化的对象
     * @throws IOException 异常
     */
    Object deserialize(InputStream input) throws IOException;
}
