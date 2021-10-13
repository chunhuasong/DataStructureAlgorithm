package fanxing;

import datatype.Array;

import java.util.*;


import java.util.ArrayList;

    public class fanxing {
        public static void main(String[] args) {
            ArrayList<String> sites = new ArrayList<String>();

            sites.add("Google");
            sites.add("Runoob");
            sites.add("Taobao");
            sites.add("Weibo");
            System.out.println(sites.get(1));  // 访问第二个元素
            sites.set(2,"Wiki");
            System.out.println(sites);
            for(int i=0;i<sites.size();i++){
                System.out.println(sites.get(i));
            }
            for(String i : sites)
            {
                System.out.println(i);
            }
        }
    }

