package cn.tansorflow.server.pojo.common.information.disk;

import lombok.Data;

@Data
public class Disk {
    private Long total;
    private Long used;
    private Float percent;
}
