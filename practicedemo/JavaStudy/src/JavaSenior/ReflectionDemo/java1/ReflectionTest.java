package JavaSenior.ReflectionDemo.java1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定的属性: 类的属性声明为public
        Field id = clazz.getField("id");
        //设置当前属性的值
        id.set(p,1001);
        //获取当前属性的值
        Object o = id.get(p);
        System.out.println(o);
        //clazz.getDeclaredField("");
    }

    @Test
    public void testField1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Tom");
        System.out.println(name.get(p));

    }
    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(p,"JAN");
        Object chn = show.invoke(p, "CHN");
        System.out.println(chn);
        System.out.println("调用静态方法");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnValue = showDesc.invoke(Person.class);
        System.out.println(returnValue);

    }


}
