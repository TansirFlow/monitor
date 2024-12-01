package cn.tansorflow.server.service.impl;


import cn.tansorflow.server.pojo.common.information.Information;
import cn.tansorflow.server.pojo.common.information.cpu.Cpu;
import cn.tansorflow.server.pojo.common.information.disk.Disk;
import cn.tansorflow.server.pojo.common.information.load.Load;
import cn.tansorflow.server.pojo.common.information.network.Speed;
import cn.tansorflow.server.pojo.common.information.network.Transform;
import cn.tansorflow.server.pojo.common.information.os.Os;
import cn.tansorflow.server.pojo.common.information.ram.Ram;
import cn.tansorflow.server.pojo.common.information.swap.Swap;
import cn.tansorflow.server.protocol.ClientInfo;
import cn.tansorflow.server.protocol.MyResponse;
import cn.tansorflow.server.protocol.UpdateServerInfoGrpc;
import cn.tansorflow.server.service.ServerService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatusServiceImpl extends UpdateServerInfoGrpc.UpdateServerInfoImplBase {
    @Autowired
    private ServerService serverService;

    @Override
    public void updateInfo(ClientInfo request, StreamObserver<MyResponse> responseObserver) {
        String serverInfo = request.getServerInfo();
        Information information = com.alibaba.fastjson.JSON.parseObject(serverInfo, Information.class);
        information.setPostTime(LocalDateTime.now());
        printSystemInfo(information);
        MyResponse response = MyResponse.newBuilder().setCode(0).setMsg("success").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private static void printSystemInfo(Information data) {
        Os os = data.getOs();
        Cpu cpu = data.getCpu();
        Ram ram = data.getRam();
        Swap swap = data.getSwap();
        Disk disk = data.getDisk();
        Transform networkTransform = data.getNetwork().getTransform();
        Speed networkSpeed = data.getNetwork().getSpeed();
        Load load = data.getLoad();

        System.out.printf("操作系统: %s%n", os.getSystem());
        System.out.printf("CPU信息: 型号=%s, 架构=%s, 核心数=%d, 使用率=%.2f%%, 主频=%s%%%n",
                cpu.getName(), cpu.getModel(), cpu.getCores(), cpu.getUsage(), cpu.getFrequency());
        System.out.printf("内存信息: 总量=%.2fG, 已用=%.2fG, 使用率=%.2f%%%n",
                ram.getTotal() / (1024 * 1024 * 1024.0f), ram.getUsed() / (1024 * 1024 * 1024.0f), ram.getPercent());
        System.out.printf("Swap信息: 总量=%.2fG, 已用=%.2fG, 使用率=%.2f%%%n",
                swap.getTotal() / (1024 * 1024 * 1024.0f), swap.getUsed() / (1024 * 1024 * 1024.0f), swap.getPercent());
        System.out.printf("硬盘信息: 总量=%.2fG, 已用=%.2fG, 使用率=%.2f%%%n",
                disk.getTotal() / (1024 * 1024 * 1024.0f), disk.getUsed() / (1024 * 1024 * 1024.0f), disk.getPercent());
        System.out.printf("流量信息: 上传=%.2fG, 下载=%.2fG%n",
                networkTransform.getBytes_sent() / (1024 * 1024 * 1024.0f), networkTransform.getBytes_recv() / (1024 * 1024 * 1024.0f));
        System.out.printf("网速信息: 上传=%.2fMB/s, 下载=%.2fMB/s%n",
                networkSpeed.getUpload(), networkSpeed.getDownload());
        System.out.printf("ip信息: %s%n", data.getNetwork().getIp());
        System.out.printf("系统负载: 1分钟=%.2f, 5分钟=%.2f, 15分钟=%.2f%n",
                load.getMin1(), load.getMin5(), load.getMin15());
        System.out.printf("系统启动时间: %s%n", os.getBoot_time());
        System.out.printf("提交时间%s", data.getPostTime());
        System.out.println("\n\n\n");
    }
}
