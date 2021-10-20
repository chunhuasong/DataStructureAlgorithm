package JavaSenior.GenericDemo;

import JavaBasic.class1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {
    @Test
    public void test1(){

        Order order = new Order();
        order.setOrderId(124);
        order.setOrderT("ABC");

        Order<String> order1 = new Order<>("orderAA",1001,"order:AA");
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("aaa");
    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
       //list1 = list2;

        Person p1 = null;
        Person p2 = null;
        p1 = p2;


    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();

        //泛型方法在调用时，指明泛型参数的类型
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
