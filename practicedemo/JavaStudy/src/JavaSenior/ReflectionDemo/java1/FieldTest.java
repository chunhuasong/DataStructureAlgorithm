package JavaSenior.ReflectionDemo.java1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println(f);
            //getFields()只调出了类与其父类的public的属性
        }
        System.out.println("*************************");
        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field d : declaredFields){
            System.out.println(d);
        }


    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //数据类型
            Class type = f.getType();
            System.out.println(type.getName());
            //变量名
            String name = f.getName();
            System.out.println(name);
            System.out.println("**********");
        }
    }
}
