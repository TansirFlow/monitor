from client import Client

if __name__=="__main__":
    agent=Client()
    agent.init_threads()
    agent.start()