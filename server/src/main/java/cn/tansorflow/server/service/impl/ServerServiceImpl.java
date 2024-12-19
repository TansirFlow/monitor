package cn.tansorflow.server.service.impl;

import cn.tansorflow.server.mapper.ServerMapper;
import cn.tansorflow.server.pojo.dto.AddServerDTO;
import cn.tansorflow.server.pojo.common.information.Information;
import cn.tansorflow.server.pojo.entity.ServerEntity;
import cn.tansorflow.server.pojo.vo.ServerInfoVO;
import cn.tansorflow.server.service.ServerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ServerServiceImpl implements ServerService {
    @Autowired
    private ServerMapper serverMapper;

    public static ConcurrentHashMap<String, Information> serverInfoList = new ConcurrentHashMap<>();

    /**
     * 更新服务器信息
     *
     * @param key
     * @param information
     */
    public static void updateInfo(String key, Information information) {
        serverInfoList.put(key, information);
        System.out.println("put:key="+key);
    }

    /**
     * 获取服务器列表
     */
    @Override
    public List<ServerEntity> list() {
        return serverMapper.list();
    }

    /**
     * 增加服务器
     *
     * @param addServerDTO
     */
    @Override
    public void add(AddServerDTO addServerDTO) {
        serverMapper.add(addServerDTO);
    }

    public Information getServerStatusByKey(String key){
        return serverInfoList.getOrDefault(key, null);
    }

    @Override
    public List<ServerInfoVO> infoList() {
        List<ServerEntity> list_originlist = serverMapper.list();
        List<ServerInfoVO> list=new ArrayList<>();
        for(ServerEntity entity:list_originlist){
            ServerInfoVO vo=new ServerInfoVO();
            BeanUtils.copyProperties(entity,vo);
            vo.setStatus(getServerStatusByKey(entity.getKey()));
            list.add(vo);
        }
        return list;
    }
}
