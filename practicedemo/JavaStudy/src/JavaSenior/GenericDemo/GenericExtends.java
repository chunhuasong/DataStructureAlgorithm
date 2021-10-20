package JavaSenior.GenericDemo;


import org.junit.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericExtends {

    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;


        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时list1,2不具备子父类关系
        //list1 = list2;
    }

 /*
    2. 通配符的使用
       通配符：?

       类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>


     */

        @Test
        public void test2(){
            List<Object> list1 = null;
            List<String> list2 = null;

            List<?> list = null;

            list = list1;
            list = list2;
            //编译通过
//        print(list1);
//        print(list2);


            //
            List<String> list3 = new ArrayList<>();
            list3.add("AA");
            list3.add("BB");
            list3.add("CC");
            list = list3;
            //添加(写入)：对于List<?>就不能向其内部添加数据。
            //除了添加null之外。
//        list.add("DD");
//        list.add('?');

            list.add(null);

            //获取(读取)：允许读取数据，读取的数据类型为Object。
            Object o = list.get(0);
            System.out.println(o);


        }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);


    }

    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

        //list2 = list3; //student是person的子类 list2最小是Person
        list2 = list4;
        //list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过 list1可能比Student大 list1<=Person
        //Student s = list1.get(0);

        list2 = list4;
        //list2>=person
         Object obj =  list2.get(0);
        ////编译不通过
        //Person person = list2.get(0);
        //Student student = list2.get(0);

        //写入数据：
        //编译不通过
        //？比person小 装一个Student会出现把student赋值给比student更小的类的情况 父类不能赋值给子类

//        list1.add(new Student());

        //编译通过

        list2.add(new Person());
        list2.add(new Student());

    }

}
