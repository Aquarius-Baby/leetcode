package temp;

import java.io.IOException;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        System.out.println(str);

    }
}


class A {
    int id;
    String name;
    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private A() {

    }
}

class B extends A {

    public B(int id, String name) {
        super(id, name);
    }
}