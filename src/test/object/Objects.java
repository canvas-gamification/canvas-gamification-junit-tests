package test.object;

import global.ObjectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// TODO: Improve error messages

public class Objects {
    public static void main(String[] args) throws Throwable {
        House h = new House();
        Class<?> c = int.class;
        Method m = House.class.getMethod("getNumber");
        System.out.println(c.equals(m.getReturnType()));
    }
}

class test {
    protected final static int x = 5;
}
