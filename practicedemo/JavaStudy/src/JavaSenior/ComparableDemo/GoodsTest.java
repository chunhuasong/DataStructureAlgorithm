package JavaSenior.ComparableDemo;


import org.junit.Test;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.lang.*;
import java.util.Arrays;
import java.util.Comparator;

public class GoodsTest {
    public static void main(String[] args) {
        Goods[] all = new Goods[3];
        all[0] = new Goods("红楼梦",100);
        all[1] = new Goods("西游", 80);
        all[2] = new Goods("三国演义", 140);

        int return_value = all[0].compareTo(all[1]);
        if(return_value>0)
            System.out.println("红楼梦贵");

        Arrays.sort(all, new Comparator() {//匿名
                    @Override
                    public int compare(Object o1, Object o2) {
                        Goods g1 = (Goods) o1;
                        Goods g2 = (Goods) o2;

                        return g1.getName().compareTo(g2.getName());
                    }
                });
                System.out.println(Arrays.toString(all));






    }
}
