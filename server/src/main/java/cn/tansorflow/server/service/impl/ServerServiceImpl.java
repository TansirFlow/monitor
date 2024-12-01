package cn.tansorflow.server.service.impl;

import cn.tansorflow.server.pojo.common.information.Information;
import cn.tansorflow.server.service.ServerService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ServerServiceImpl implements ServerService {
    public static ConcurrentHashMap<String, Information> serverInfoList = new ConcurrentHashMap<>();

    /**
     * 更新服务器信息
     * @param key
     * @param information
     */
    @Override
    public void updateInfo(String key, Information information) {
        if(serverInfoList.containsKey(key)){
            serverInfoList.put(key, information);
        }
    }

    /**
     * 获取服务器列表
     */
    @Override
    public void getServerList() {

    }
}
