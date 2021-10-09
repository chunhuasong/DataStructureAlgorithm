package setDemo;

import java.util.ArrayList;
import java.util.List;

public class LIst {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("aaa");
        list1.add("bbb");
        List<String> list2 = new ArrayList<String>();
        list2.add("ccc");
        list2.add("ddd");

        list1.remove(0);

        List<String> listMerge = new ArrayList<String>();
        listMerge.addAll(list1);
        listMerge.addAll(list2);
        for (String str: listMerge){
            System.out.println(str);
        }

        System.out.println("list1 长度为："  +  list1.size());
        // 清楚list
        list1.clear();
        System.out.println("list1 长度为："  +  list1.size());
        if(list1.isEmpty()){
            System.out.println("此时list1 为空");
        }
    }
}
