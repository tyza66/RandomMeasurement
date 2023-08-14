import jpype
import jpype.imports
from jpype.types import *
import os.path

jarpath = os.path.abspath('.')

jpype.startJVM()
# 测试输出
jpype.java.lang.System.out.println("Hello World")

# 添加类路径
jpype.addClassPath(jarpath + "/Jtest.jar")

# 加载jar包
jtest = JClass("Jtest")

# 调用方法
end = jtest.sum(90, 6)

print(end)

jpype.shutdownJVM()
