package cn.tansorflow.server.pojo.entity;

import lombok.Data;

@Data
public class ServerEntity {
    private Integer id;
    private String name;
    private Integer index;
    private String group;
    private Integer needLogin;
    private String key;
    private String note;
}
