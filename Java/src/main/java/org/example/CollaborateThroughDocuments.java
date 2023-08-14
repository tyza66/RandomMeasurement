package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/8/14 11:19
 * Github: https://github.com/tyza66
 * 实验目的 通过文件读写实现不同编程语言之间的相互合作
 **/

/*
* 文件中保存的命令
* 1.第一部分 指令本身 0-打印 1计算总和
* 2.第二部分 携带的参数 啥也不写（空串）-没参数 一堆用&分割的数字-不定量参数
* 3.第三部分 指令当前状态 0 未被执行 1 已被执行
* */

public class CollaborateThroughDocuments {
    public static void main(String[] args) throws IOException {
        List<String> strings = OperationFileReadingContent.readLastLine("D:\\Project\\RandomMeasurement\\Java\\src\\main\\java\\org\\example\\testTranslate.txt");
        for (String string : strings) {
            String[] split = string.split(",");
            if (split[0].equals("0")) {
                //执行打印操作
                System.out.println(split[1]);
            } else if (split[0].equals("1")) {
                //执行相加操作
                String[] parameter = split[1].split("&");
                System.out.println(Integer.parseInt(parameter[0]) + Integer.parseInt(parameter[1]));
            }
        }
    }
}

class OperationFileReadingContent{
    //读取文本文件后面要执行的行
    public static List<String> readLastLine(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> codes = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            if (split[2].equals("0")) {
                codes.add(line);
            }
        }
        reader.close();
        return codes;
    }
}

