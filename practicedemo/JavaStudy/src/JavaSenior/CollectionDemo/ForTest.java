package JavaSenior.CollectionDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        for(Object obj: coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        String[] str = new String[5];
        for (String myStr : str) {//str没变 把str给myStr
            myStr = "atguigu";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

        //输出5个atguigu和五个null
    }

}
