package JavaSenior.ThreadDemo;

import java.util.ArrayList;

// 线程不安全的集合
//因为两个线程，同一瞬间操作了同一个位置，把两个数组添加到了同一个位置，于是就把他覆盖掉了，元素就会少了
class ArrayListThread {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                strings.add(Thread.currentThread().getName());// 添加一个集合的元素
            }).start();
        }
        //Thread.sleep(1000);// 延迟 1 秒
        System.out.println(strings.size());// 返回集合的长度
    }
}
