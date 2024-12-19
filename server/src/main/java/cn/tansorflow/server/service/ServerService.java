package cn.tansorflow.server.service;

import cn.tansorflow.server.pojo.dto.AddServerDTO;
import cn.tansorflow.server.pojo.common.information.Information;
import cn.tansorflow.server.pojo.entity.ServerEntity;
import cn.tansorflow.server.pojo.vo.ServerInfoVO;

import java.util.List;

public interface ServerService {
    List<ServerEntity> list();

    void add(AddServerDTO addServerDTO);

    List<ServerInfoVO> infoList();
}
