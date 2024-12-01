
import time


import psutil
import platform
from datetime import datetime


import requests


def get_public_ip():
    try:
        # 使用httpbin.org服务来获取公网IP
        response = requests.get('https://httpbin.org/ip')
        response.raise_for_status()  # 如果响应状态码不是200，会抛出异常
        data = response.json()
        public_ip = data.get('origin', '未知')
        return [public_ip]
    except requests.RequestException as e:
        print(f"无法获取公网IP: {e}")
        return ['']


# 获取操作系统信息
def get_os_info():
    return platform.system() + platform.release()


def get_cpu_model():
    with open('/proc/cpuinfo', 'r') as f:
        for line in f:
            if "model name" in line:
                # 去掉前后的空白字符，并分割字符串以获取CPU型号
                return line.split(':')[1].strip()
    return "Unknown"


# 获取CPU信息
def get_cpu_info():
    cpu_percent = psutil.cpu_percent(interval=1)  # CPU占用率
    cpu_count = psutil.cpu_count(logical=True)  # 逻辑核心数
    cpu_freq = psutil.cpu_freq()  # 当前频率
    return {
        "model": platform.processor(),  # CPU型号,
        "name": get_cpu_model(),
        "cores": cpu_count,
        "usage": cpu_percent,
        "frequency": f"{cpu_freq.current} Mhz"
    }


# 获取内存信息
def get_memory_info():
    memory = psutil.virtual_memory()
    return {
        "total": memory.total,  # 总量
        "used": memory.used,  # 使用量
        "percent": memory.percent  # 占用百分比
    }


# 获取交换分区信息
def get_swap_info():
    swap = psutil.swap_memory()
    return {
        "total": swap.total,  # 总量
        "used": swap.used,  # 使用量
        "percent": swap.percent  # 占用百分比
    }


# 获取磁盘信息
def get_disk_info():
    disk_usage = psutil.disk_usage('/')
    return {
        "total": disk_usage.total,  # 总量
        "used": disk_usage.used,  # 使用量
        "percent": disk_usage.percent  # 占用百分比
    }


# 获取网络流量信息
def get_transform_info():
    net_io = psutil.net_io_counters()
    return {
        "bytes_sent": net_io.bytes_sent,  # 发送字节数
        "bytes_recv": net_io.bytes_recv  # 接收字节数
    }


# 获取系统负载
def get_load_average():
    load_avg = psutil.getloadavg()
    return {
        "min1": load_avg[0],  # 1分钟平均负载
        "min5": load_avg[1],  # 5分钟平均负载
        "min15": load_avg[2]  # 15分钟平均负载
    }


# 获取系统启动时间
def get_boot_time():
    boot_time_timestamp = psutil.boot_time()
    bt = datetime.fromtimestamp(boot_time_timestamp)
    return bt.strftime("%Y-%m-%d %H:%M:%S")


def calculate_speed(prev, current, interval):
    """ 计算给定时间间隔内的数据传输速率（单位：MB/s） """
    return (current - prev) / interval / 1024.0 / 1024.0


def get_network_speed(interval=1):
    # 获取初始的网络I/O计数
    net_io = psutil.net_io_counters()
    bytes_sent_start = net_io.bytes_sent
    bytes_recv_start = net_io.bytes_recv

    # 等待一段时间
    time.sleep(interval)

    # 再次获取网络I/O计数
    net_io = psutil.net_io_counters()
    bytes_sent_end = net_io.bytes_sent
    bytes_recv_end = net_io.bytes_recv

    # 计算速度
    upload_speed = calculate_speed(bytes_sent_start, bytes_sent_end, interval)
    download_speed = calculate_speed(bytes_recv_start, bytes_recv_end, interval)

    return {
        "upload": round(upload_speed, 2),
        "download": round(download_speed, 2)
    }


# 主函数
def get():
    return {
        "os": {
            "system": get_os_info(),
            "boot_time": get_boot_time()
        },
        "cpu": get_cpu_info(),
        "ram": get_memory_info(),
        "swap": get_swap_info(),
        "disk": get_disk_info(),
        "network": {
            "transform": get_transform_info(),
            "speed": get_network_speed()
        },
        "load": get_load_average(),
    }
