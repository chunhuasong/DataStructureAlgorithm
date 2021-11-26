package Algorithm.Searching;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author songhuan
 * @date 2021/11/15 15:54
 */
public class HashTableSearch {

    static int[] element  = {12,25,37,15,16,29,48,67,56,22,47};
    static int m = element.length;

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        InitHash(hashMap,element);
        InsertHash(hashMap,90);
        System.out.println(SearchHash(hashMap,67));

    }


    static int Hash(int key,int m){
        return key % m;
    }

    static void InitHash(HashMap hashMap,int[] element){

        for(int i = 0;i < element.length; i++){
            int addr = Hash(element[i],m);
            while(hashMap.containsKey(addr)){
                addr = (addr + 1) % m;
            }
            hashMap.put(addr,element[i]);

        }
        System.out.println("初始化为："+ hashMap);
    }


    static public void InsertHash(HashMap hashMap,int key){
        int addr = Hash(key,m);
        int count = 0;
        while(hashMap.containsKey(addr) && count < hashMap.size()){
                addr = (addr + 1) % m;
                count++;
            }
        hashMap.put(hashMap.size(),key);
        System.out.println("插入结果为："+ hashMap);
    }

    static boolean SearchHash(HashMap hashMap,int key){
        int addr = Hash(key,m);
        int count = 0;
        while((int)hashMap.get(addr) != key && count < hashMap.size()){
            addr = (addr + 1) % m;
            count++;
        }
        if(count == hashMap.size()){
            System.out.println("没有这个值");
            return false;
        }
        System.out.println("搜索结果为："+ addr);
        return true;
    }



}
