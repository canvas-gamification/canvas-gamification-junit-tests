package test.object;

import global.ObjectTest;

// TODO: Improve error messages

public class Objects {
    public static void main(String[] args) throws Throwable {
        int x = 5;
        Object[] c = {x};
        System.out.println(c[0].getClass());
    }
}
