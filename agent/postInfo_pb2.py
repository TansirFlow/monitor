# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# NO CHECKED-IN PROTOBUF GENCODE
# source: postInfo.proto
# Protobuf Python Version: 5.28.1
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import runtime_version as _runtime_version
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
_runtime_version.ValidateProtobufRuntimeVersion(
    _runtime_version.Domain.PUBLIC,
    5,
    28,
    1,
    '',
    'postInfo.proto'
)
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x0epostInfo.proto\"-\n\nClientInfo\x12\x12\n\nserverInfo\x18\x01 \x01(\t\x12\x0b\n\x03key\x18\x02 \x01(\t\"\'\n\nMyResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0b\n\x03msg\x18\x02 \x01(\t2<\n\x10UpdateServerInfo\x12(\n\nupdateInfo\x12\x0b.ClientInfo\x1a\x0b.MyResponse\"\x00\x42!\n\x1d\x63n.tansorflow.server.protocolP\x01\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'postInfo_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  _globals['DESCRIPTOR']._loaded_options = None
  _globals['DESCRIPTOR']._serialized_options = b'\n\035cn.tansorflow.server.protocolP\001'
  _globals['_CLIENTINFO']._serialized_start=18
  _globals['_CLIENTINFO']._serialized_end=63
  _globals['_MYRESPONSE']._serialized_start=65
  _globals['_MYRESPONSE']._serialized_end=104
  _globals['_UPDATESERVERINFO']._serialized_start=106
  _globals['_UPDATESERVERINFO']._serialized_end=166
# @@protoc_insertion_point(module_scope)
