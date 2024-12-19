package cn.tansorflow.server.pojo.dto;

import lombok.Data;

@Data
public class AddServerDTO {
    private String name;
    private Integer index;
    private String group;
    private Integer needLogin;
    private String key;
    private String note;
}
