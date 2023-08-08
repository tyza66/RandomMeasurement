package org.example;

/**
 * Author: tyza66
 * Date: 2023/8/8 13:46
 * Github: https://github.com/tyza66
 **/

public class ParentClassSubclassWhoComesFirstAndWhoComesLater {
    public static void main(String[] args) {
        new Child();
    }
}


class Parent {
    private String name = "parent";

    public Parent() {
        sayName();
        sqyWho();
    }

    public void sayName() {
        System.out.println(name);
    }

    public void sqyWho() {
        System.out.println("I am " + name);
    }

}

class Child extends Parent {
    private String name = "child";

    public Child() {
        sayName();
        sqyWho();
    }

    public void sayName() {
        System.out.println(name);
    }

    public void sqyWho() {
        System.out.println("I am " + name);
    }
}