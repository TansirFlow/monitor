package cn.tansorflow.server.pojo.vo;

import cn.tansorflow.server.pojo.common.information.Information;
import lombok.Data;

@Data
public class ServerInfoVO {
    private Integer id;
    private String name;
    private Integer index;
    private String group;
    private Integer needLogin;
    private String key;
    private String note;
    private Information status;
}
