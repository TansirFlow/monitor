// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: postInfo.proto

package cn.tansorflow.server.protocol;

public final class PostInfo {
  private PostInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ClientInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ClientInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MyResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016postInfo.proto\"-\n\nClientInfo\022\022\n\nserver" +
      "Info\030\001 \001(\t\022\013\n\003key\030\002 \001(\t\"\'\n\nMyResponse\022\014\n" +
      "\004code\030\001 \001(\005\022\013\n\003msg\030\002 \001(\t2<\n\020UpdateServer" +
      "Info\022(\n\nupdateInfo\022\013.ClientInfo\032\013.MyResp" +
      "onse\"\000B!\n\035cn.tansorflow.server.protocolP" +
      "\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ClientInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ClientInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ClientInfo_descriptor,
        new java.lang.String[] { "ServerInfo", "Key", });
    internal_static_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MyResponse_descriptor,
        new java.lang.String[] { "Code", "Msg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}