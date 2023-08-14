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
    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = "D:\\Project\\RandomMeasurement\\Java\\src\\main\\java\\org\\example\\testTranslate.txt";
        OperationFileReadingContent.readLLines(filePath);
        OperationFileReadingContent.addLine(filePath, "0", "HelloWorld!");
    }
}

class OperationFileReadingContent {
    //读取文本文件后面要执行的行 并且直接执行
    public static void readLLines(String filePath) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int num = 0;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            if (split[2].equals("0")) {
                /*System.out.println("执行第" + num + "行");
                System.out.println(split[2]);
                System.out.println(split[2].equals("0"));*/
                String[] split1 = line.split(",");
                if (split1[0].equals("0")) {
                    //执行打印操作
                    System.out.println(split1[1]);
                    //将执行了的行置于已执行状态
                    setLineToExecuted(filePath, num);
                } else if (split1[0].equals("1")) {
                    //执行相加操作
                    String[] parameter = split1[1].split("&");
                    System.out.println(Integer.parseInt(parameter[0]) + Integer.parseInt(parameter[1]));
                    setLineToExecuted(filePath, num);
                }
            }
            num++;
        }
        reader.close();
    }

    //将文本某行置于已执行状态
    public static void setLineToExecuted(String filePath, int line) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> codes = new ArrayList<>();
        String line1;
        while ((line1 = reader.readLine()) != null) {
            codes.add(line1);
        }
        reader.close();
        codes.set(line, codes.get(line).split(",")[0] + "," + codes.get(line).split(",")[1] + ",1");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String code : codes) {
            writer.write(code);
            writer.newLine();
        }
        writer.close();
    }

    //向文件中最后一行写入一行新的指令，并且置于未执行状态
    public static void addLine(String filePath, String code, String parmas) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.write(code + "," + parmas + ",0");
        writer.newLine();
        writer.close();
    }
}

