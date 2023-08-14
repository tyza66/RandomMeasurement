# 打开文件并且读取执行
def read_and_run(path):
    with open(path, 'r') as file:
        lines = file.readlines()
        num = 0
        # 读取文本每一行
        for line in lines:
            # 三部分分割
            one = line.strip().split(",")
            # 如果是未执行的行就执行
            if one[2] == "0":
                # 打印
                if one[0] == "0":
                    print(one[1])
                    mark(path, num)
                    # 相加求和
                if one[0] == "1":
                    print(int(one[1].split("&")[0]) + int(one[1].split("&")[1]))
                    mark(path, num)
            num += 1


# 将执行过的行标记为已经执行
def mark(path, line):
    with open(path, 'r') as file:
        lines = file.readlines()
        # 修改指定行
        lines[line] = lines[line].strip().split(",")[0] + "," + lines[line].strip().split(",")[1] + ",1\n"
    with open(path, 'w') as file:
       file.writelines(lines)


#向文件中新的一行中写入新的指令
def add_line(path, code,parmas):
    with open(path, 'a') as file:
        file.write(code+","+parmas+",0\n")


if __name__ == '__main__':
    path = "D:\\Project\\RandomMeasurement\\Java\\src\\main\\java\\org\\example\\testTranslate.txt"
    read_and_run(path);
    add_line(path,"1","1&2")
