package cn.tansorflow.server.mapper;

import cn.tansorflow.server.pojo.dto.AddServerDTO;
import cn.tansorflow.server.pojo.entity.ServerEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServerMapper {
    @Insert("insert into server (name,`index`,`group`,need_login,key,note) " +
            "values (#{name},#{index},#{group},#{needLogin},#{key},#{note})")
    void add(AddServerDTO addServerDTO);

    @Select("select * from server")
    List<ServerEntity> list();
}
