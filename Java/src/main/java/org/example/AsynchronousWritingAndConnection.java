package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: tyza66
 * Date: 2023/8/7 14:51
 * Github: https://github.com/tyza66
 * 测试目的 异步写入文本并且衔接
 * 测试结果 成功
 **/
class AsynchronousWritingAndConnection {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Project\\untitled\\src\\main\\java\\org\\example\\write.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        new Thread(() -> {
            synchronized (fileOutputStream) {
                try {
                    fileOutputStream.write("How are you\n".getBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (fileOutputStream) {
                try {
                    fileOutputStream.write("I am fine".getBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}