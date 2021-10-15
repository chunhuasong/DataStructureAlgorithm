package JavaSenior.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);

            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
//1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        System.out.println(service.getClass());
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        service1.setCorePoolSize(5);
        //执行指定线程的操作，需要提供实现Runnable或者Callable接口
        service.execute(new NumberThread());//使用于Runnable
        //service.submit();//使用于Callable

        //关闭连接池
        service.shutdown();
    }
}

