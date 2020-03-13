package temp;

import java.util.LinkedList;
import java.util.List;

public class ExtendTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 15) {
            index = (index + 9 - 1) % list.size();
            System.out.println("delete : " + (list.get(index) ));
            list.remove(index);
        }
        for (int i : list) {
            System.out.print(i + ",");
        }
    }


    private static void test() {
        String a = "abc";
        String b = "abc";
        String c = "a" + "bc";

        String d = new String("abc");
        String e = new String("abc");

        System.out.println(a == b); // true
        System.out.println(a == c); // true
        System.out.println(a == d); // false
        System.out.println(a.equals(d));// true
        System.out.println(d == e); // false
        System.out.println(d.equals(e));// true
    }

    private static void test1() {
        Father father = new Father();
        father.run();
        System.out.println(father);
        System.out.println("--------------------------------");

        Father father1 = new Son();
        father1.run();
        System.out.println(father1);
        System.out.println("--------------------------------");

        Son son = new Son();
        son.run();
        System.out.println(son);
        System.out.println("--------------------------------");
    }
}


class Father {
    String name;
    int age;

    public Father() {
        name = "father name";
        age = 51;
        System.out.println("father init.....");
    }

    public void run() {
        System.out.println("Father RUN");
    }

    @Override
    public String toString() {
        return " content : " + name + ' ' + age;
    }
}


class Son extends Father {
    String hobby;


    public Son() {
        super();
        name = "son name";
        System.out.println("son init ~~~~~");
    }

    public void run() {
        System.out.println("SON RUN");
    }
}
