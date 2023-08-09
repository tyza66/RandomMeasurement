#by:tyza66
#实验目的 使用python控制命令调用java程序并且把返回值拿过来
import subprocess

def run():
    result = subprocess.run("javac",shell=True,capture_output=True,text=True)
    print(result)

if __name__ == '__main__':
    run()