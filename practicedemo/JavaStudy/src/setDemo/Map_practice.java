package setDemo;

import java.util.HashMap;
import java.util.Map;

public class Map_practice {
    //练习题1：往一个Map集合中添加若干元素。获取Map中的所有value，并使用for遍历输出每个value。
    public static void main(String[] args) {
        Map<String,String> map= new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        for (String str : map.values()){
            System.out.println(str);
        }
        for (String str : map.keySet()){
            System.out.println(str);
        }
    }


}
