#by:tyza66
#实验目的 使用python控制命令调用java程序并且把返回值拿过来
import subprocess

def run():
    result = subprocess.run("javac SimpleAddition.java",shell=True,capture_output=True,text=True)
    #print(result)
    result = subprocess.run("java SimpleAddition 1 2",shell=True,capture_output=True,text=True)
    print(result.stdout)

if __name__ == '__main__':
    run()