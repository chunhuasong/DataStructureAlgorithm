package JavaSenior.ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

class WindowL implements Runnable{
    private int ticket = 100;
//实例化ReentrantLock
     private ReentrantLock lock =new ReentrantLock(true);
     //true:先进先出 公平
   @Override
    public void run() {
        while(true){
            try{
                //调用lock方法
                lock.lock();;
                if(ticket > 0)
                {
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally{
                //调用解锁方法
                lock.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        WindowL w = new WindowL();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
