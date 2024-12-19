package cn.tansorflow.server.controller;

import cn.tansorflow.server.pojo.dto.AddServerDTO;
import cn.tansorflow.server.pojo.common.result.Result;
import cn.tansorflow.server.pojo.entity.ServerEntity;
import cn.tansorflow.server.pojo.vo.ServerInfoVO;
import cn.tansorflow.server.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServiceController {
    @Autowired
    private ServerService serverService;
    @PostMapping
    public Result addServer(@RequestBody AddServerDTO addServerDTO){
        serverService.add(addServerDTO);
        return Result.success();
    }
    @GetMapping
    public Result<List<ServerEntity>> list(){
        List<ServerEntity> list=serverService.list();
        return Result.success(list);
    }
    @GetMapping("/status")
    private Result<List<ServerInfoVO>> infoList(){
        List<ServerInfoVO> list=serverService.infoList();
        return Result.success(list);
    }
}
