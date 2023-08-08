package org.example;

/**
 * Author: tyza66
 * Date: 2023/8/8 15:44
 * Github: https://github.com/tyza66
 * 测试目的 检查父类构造是否会走子类重写了的方法
 * 测试结果 父类构造会走子类重写了的方法
 **/

public class ParentClassConstructionWillExecuteMethodsOverriddenInSubclasses {
    public static void main(String[] args) {
        new Child1();
    }
}


class Child1 extends Parent1{
    public Child1() {
        super();
    }

    @Override
    public void say() {
        System.out.println("giao2");
    }
}

class Parent1{
    public Parent1() {
        say();
    }

    public void say() {
        System.out.println("giao1");
    }
}