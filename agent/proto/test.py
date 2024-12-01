import grpc


def send_info(stub,msg):
    request = update_pb2.StatusInfo(info=msg)
    response = stub.updateInfo(request)

def run():
    # # 创建一个到gRPC服务器的安全或非安全通道
    # with grpc.insecure_channel('pf.tansor.top:11100') as channel:
    #     # 创建服务存根
    #     stub = update_pb2_grpc.UpdateStub(channel)
    #     send_info(stub,"12345")
    # 连接 rpc 服务器
    channel = grpc.insecure_channel('218.93.208.28:11100')
    # 调用 rpc 服务
    stub = update_pb2_grpc.UpdateStub(channel)
    response = stub.updateInfo(update_pb2.StatusInfo(info='12345'))
    print(response.message)


if __name__ == '__main__':
    run()