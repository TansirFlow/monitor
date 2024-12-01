package cn.tansorflow.server.pojo.common.information.ram;

import lombok.Data;

@Data
public class Ram {
    private Long total;
    private Long used;
    private Float percent;
}
