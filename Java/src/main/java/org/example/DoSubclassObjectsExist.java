package org.example;

/**
 * Author: tyza66
 * Date: 2023/8/8 16:46
 * Github: https://github.com/tyza66
 * 测试目的 检查子类对象在父类的构造方法没有执行完成之前是否存在
 * 测试结果 不存在
 **/

public class DoSubclassObjectsExist {
    public static void main(String[] args) {
        new Child2();
    }
}

class Parent2 {
    public int a = 1;

    public Parent2() {
        call();
    }

    public void call() {
    }
}

class Child2 extends Parent2 {
    int b = 2;

    public Child2() {

    }

    public void call() {
        System.out.println(this.b);
    }

}