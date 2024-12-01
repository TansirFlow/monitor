package cn.tansorflow.server.pojo.common.information.cpu;

import lombok.Data;

@Data
public class Cpu {
    private String model;
    private String name;
    private Integer cores;
    private Float usage;
    private String frequency;
}
