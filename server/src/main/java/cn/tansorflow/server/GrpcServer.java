package cn.tansorflow.server;

import cn.tansorflow.server.service.impl.StatusServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GrpcServer {
    private Server server;

    @PostConstruct
    public void start() throws Exception {
        server = ServerBuilder.forPort(10086) // 指定端口
                .addService(new StatusServiceImpl()) // 注册服务实现
                .build()
                .start();
        System.out.println("GRPC server started on port: " + server.getPort());
//        server.awaitTermination();
    }
}