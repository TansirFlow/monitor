package cn.tansorflow.server.service;

import cn.tansorflow.server.pojo.common.information.Information;

public interface ServerService {
    void updateInfo(String key, Information information);
    void getServerList();
}
