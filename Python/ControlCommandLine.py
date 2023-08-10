# by:tyza66
# 实验目的 使用python控制命令调用java程序并且把返回值拿过来
import subprocess


def run(a, b):
    # 使用subprocess.run()方法来调用控制台命令
    result = subprocess.run("javac SimpleAddition.java", shell=True, capture_output=True, text=True)
    # print(result)
    result = subprocess.run("java SimpleAddition " + str(a) + " " + str(b), shell=True, capture_output=True, text=True)
    # 拿到执行结果返回值
    print(result.stdout)


if __name__ == '__main__':
    run(1, 2)


