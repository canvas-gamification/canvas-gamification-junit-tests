package temp;


import global.utils.ClassUtil;
import org.junit.jupiter.api.Test;
import temp.test.Bubble;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {
    @Test
    public void testBubbleAttr() {
        System.err.println(Arrays.toString(ClassUtil.getAllAttributes(Bubble.class)));
        assertTrue(ClassUtil.classHasAttribute(Bubble.class, "private int radius"), "Bubble class should have a radius attribute");
    }

    @Test
    public void testBubbleMethods() {
        System.err.println((Arrays.toString(ClassUtil.getAllMethods(Bubble.class))));
        assertTrue(ClassUtil.classHasMethods(Bubble.class, "public double getArea()", "public void setRadius(int)"), "Bubble class should have a getArea method");
    }

    @Test
    public void testBubbleConstructors() {
        System.err.println(Arrays.toString(ClassUtil.getAllConstructors(Bubble.class)));
        assertTrue(ClassUtil.classHasConstructor(Bubble.class, "Bubble(int,int)"), "Bubble class should have a two parameter constructor");
    }
}
