package JavaSenior.ReflectionDemo;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class clazz = Person.class;
        Object obj = clazz.newInstance();//调的空参构造器 构造器不能是private权限
        System.out.println(obj);

    }

    @Test
    public void test2(){
                /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "JavaSenior.ReflectionDemo.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
