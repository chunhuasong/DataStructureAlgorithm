package JavaSenior.setDemo;

import java.util.*;

public class Haxibiao {
    public static void main(String[] args){

        //1.创建Map集合
        //HashMap的默认初始化值是16，默认加载因子是0.75
        //Map<String, String > map =new HashMap();
        Map<String, String> map =new HashMap<>();

        //2.存储键值对 map.put("key","value");
        map.put("10000","jack");
        map.put("13000","luck");
        map.put("10400","tom");
        map.put("10020","lucy");
        map.put("10200","kim");
        map.put("10000","lisa");

        //3.判断键值对的个数
        //Map中的Key是无序不可重复的，和HashCode相同
        System.out.println(map.size());//5

        //4.判断集合中是否包含这样的Key
        System.out.println(map.containsKey("10000"));//true

        //5.判断集合中是否包含这样的Value
        //注意：Map中如果Key重复了，value采用的是覆盖
        System.out.println(map.containsValue("lisa"));//true
        System.out.println(map.containsValue("jack"));//false
//        //6.通过Key获取Value
//        Object v=map.get("10200");
//        System.out.println(v);
//
        Object v=map.get("10200");
        System.out.println(v);
//        //7.通过Key删除键值对
//        map.remove("10200");
//        System.out.println(map.size());//4
        map.remove("10200");

//
//
//        //8.获取所有的value
//        Collection values=map.values();
//        Iterator it=values.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }.
        Collection values = map.values();
        Iterator it=values.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
//
//        //9获取所有的Key
//        //以下程序演示如何遍历Map集合
//        Set Keys=map.keySet();
//        Iterator it1=Keys.iterator();
//        while(it1.hasNext()){
//            Object no=it1.next();
//            Object name=map.get(no);
//            System.out.println(no+"-->"+name);
//        }
        Set Keys=map.keySet();
        Iterator it1=Keys.iterator();
        while(it1.hasNext()){
            Object no=it1.next();
            Object name=map.get(no);
            System.out.println(no+"-->"+name);
        }
//        // 匿名对象的方式，和上面的代码功能完全一致
//        while(map.keySet().iterator().hasNext()){
//            Object no=it1.next();
//            Object name=map.get(no);
//            System.out.println(no+"-->"+name);
//        }
//

//        //10.entrySet
//        //将Map转换成Set集合
//        Set set=map.entrySet();
//        Iterator it2=set.iterator();
//        while(it2.hasNext()){
//            System.out.println(it2.next());
//        }
//
//        while(map.entrySet().iterator().hasNext()){
//            System.out.println(it2.next());
//        }
//
        Set set=map.entrySet();
        Iterator it2= set.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
//        while(map.entrySet().iterator().hasNext()){
//            System.out.println(it2.next());
//        }
    }
}
