package cn.tansorflow.server.pojo.common.information.network;

import lombok.Data;

import java.util.List;

@Data
public class Network {
    private Transform transform;
    private Speed speed;
    private List<String> ip;
}
