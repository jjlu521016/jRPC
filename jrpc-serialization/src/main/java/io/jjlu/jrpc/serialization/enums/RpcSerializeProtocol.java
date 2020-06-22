package io.jjlu.jrpc.serialization.enums;

/**
 * RPC序列化方式枚举
 */
public enum RpcSerializeProtocol {
    /**
     * jdk原生的序列化
     */
    JDK("jdknative"),
    /**
     * kryo
     */
    KRYO("kryo"),
    /**
     * hessian
     */
    HESSIAN("hessian"),
    /**
     * protobuf
     */
    PROTOBUF("protobuf");

    private final String serializeProtocol;

    RpcSerializeProtocol(String serializeProtocol) {
        this.serializeProtocol = serializeProtocol;
    }

    public String getProtocol() {
        return serializeProtocol;
    }
}
