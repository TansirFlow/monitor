import time

import util
import postInfo_pb2
import postInfo_pb2_grpc
import grpc
import json
import threading


class Client:
    def __init__(self):
        self.serverInfo = {
            'os': {
                'system': ('Linux', '5.15.167.4-microsoft-standard-WSL2'),
                'boot_time': '2024-12-01 00:24:20'
            },
            'cpu': {
                'model': 'x86_64',
                'name': '11th Gen Intel(R) Core(TM) i7-11700 @ 2.50GHz',
                'cores': 16,
                'usage': 1.9,
                'frequency': '2495.998 Mhz'
            },
            'ram': {
                'total': 16693673984,
                'used': 3244261376,
                'percent': 21.2
            },
            'swap': {
                'total': 4294967296,
                'used': 0,
                'percent': 0.0
            },
            'disk': {
                'total': 1081101176832,
                'used': 38127796224,
                'percent': 3.7
            },
            'network': {
                'ip': ["1.1.1.1", "8.8.8.8"],
                'transform': {
                    'bytes_sent': 7081705,
                    'bytes_recv': 30961570
                },
                'speed': {
                    'upload': 0.0,
                    'download': 0.0
                }
            },
            'load': {
                '1min': 0.7744140625,
                '5min': 0.625,
                '15min': 0.3759765625
            }
        }

        self.key = "12345"
        self.threads = []
        self.channel = None
        self.stub = None
        self.reconnect_interval = 5  # 重连间隔时间（秒）

    def refresh_os(self):
        while True:
            self.serverInfo['os'] = {
                'system': util.get_os_info(),
                'boot_time': util.get_boot_time()
            }
            time.sleep(1)

    def refresh_cpu(self):
        while True:
            self.serverInfo['cpu'] = util.get_cpu_info()
            time.sleep(1)

    def refresh_ram(self):
        while True:
            self.serverInfo['ram'] = util.get_memory_info()
            time.sleep(1)

    def refresh_swap(self):
        while True:
            self.serverInfo['swap'] = util.get_swap_info()
            time.sleep(1)

    def refresh_disk(self):
        while True:
            self.serverInfo['disk'] = util.get_disk_info()
            time.sleep(1)

    def refresh_ip(self):
        while True:
            self.serverInfo['network']['ip'] = util.get_public_ip()
            time.sleep(10)

    def refresh_network(self):
        while True:
            self.serverInfo['network']['transform'] = util.get_transform_info()
            self.serverInfo['network']['speed'] = util.get_network_speed()
            time.sleep(1)

    def refresh_load(self):
        while True:
            self.serverInfo['load'] = util.get_load_average()
            time.sleep(1)

    def connect_to_server(self):
        print("Connecting to the gRPC server...")
        self.channel = grpc.insecure_channel('218.93.208.28:11100')
        self.stub = postInfo_pb2_grpc.UpdateServerInfoStub(self.channel)
        print("Connected to the gRPC server.")

    def send(self):
        while True:
            if not self.channel or not self.stub:
                self.connect_to_server()

            try:
                response = self.stub.updateInfo(
                    postInfo_pb2.ClientInfo(serverInfo=json.dumps(self.serverInfo), key=self.key))
                time.sleep(1)
            except grpc.RpcError as e:
                print(f"An error occurred: {e}")
                if e.code() == grpc.StatusCode.UNAVAILABLE:
                    print("The server is unavailable. Attempting to reconnect...")
                    self.channel = None
                    self.stub = None
                    time.sleep(self.reconnect_interval)
                else:
                    print(f"Unexpected error: {e.details()}")

    def init_threads(self):
        self.threads.append(threading.Thread(target=self.refresh_os))
        self.threads.append(threading.Thread(target=self.refresh_cpu))
        self.threads.append(threading.Thread(target=self.refresh_ram))
        self.threads.append(threading.Thread(target=self.refresh_swap))
        self.threads.append(threading.Thread(target=self.refresh_disk))
        self.threads.append(threading.Thread(target=self.refresh_ip))
        self.threads.append(threading.Thread(target=self.refresh_network))
        self.threads.append(threading.Thread(target=self.refresh_load))
        self.threads.append(threading.Thread(target=self.send))
        # self.threads.append(threading.Thread(target=self.test_output))

    def start(self):
        for thread in self.threads:
            thread.start()

    def test_output(self):
        while True:
            print(self.serverInfo)
            time.sleep(1)
