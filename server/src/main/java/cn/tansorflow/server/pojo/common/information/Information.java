package cn.tansorflow.server.pojo.common.information;


import cn.tansorflow.server.pojo.common.information.cpu.Cpu;
import cn.tansorflow.server.pojo.common.information.disk.Disk;
import cn.tansorflow.server.pojo.common.information.load.Load;
import cn.tansorflow.server.pojo.common.information.network.Network;
import cn.tansorflow.server.pojo.common.information.os.Os;
import cn.tansorflow.server.pojo.common.information.ram.Ram;
import cn.tansorflow.server.pojo.common.information.swap.Swap;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Information {
    private Os os;
    private Cpu cpu;
    private Ram ram;
    private Swap swap;
    private Disk disk;
    private Network network;
    private Load load;
    private LocalDateTime postTime;
}
