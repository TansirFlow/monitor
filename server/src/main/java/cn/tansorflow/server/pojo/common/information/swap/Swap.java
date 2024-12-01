package cn.tansorflow.server.pojo.common.information.swap;

import lombok.Data;

@Data
public class Swap {
    private Long total;
    private Long used;
    private Float percent;
}
