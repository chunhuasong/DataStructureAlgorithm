package JavaSenior.GenericDemo;

import JavaBasic.datatype.Array;
import org.junit.Test;

import java.util.*;

public class GenericTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
        //list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);

        }

    }

    @Test
    public void test2(){
       ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //list.add("T");
        for(Integer score : list){
            int stuScore = score;
            System.out.println(stuScore);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int studentscore = iterator.next();
            System.out.println(studentscore);
        }
    }

    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            System.out.println(e.getKey());
        }
    }

}
