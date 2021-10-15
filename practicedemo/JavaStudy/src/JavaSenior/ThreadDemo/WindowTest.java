package JavaSenior.ThreadDemo;
//三个窗口卖票 一共卖100张
//票号100卖了3次 线程安全问题
import java.awt.*;

class Window extends Thread{
    private static int ticket = 100;//静态共享一个变量
    private static Object object = new Object();
    @Override
    public void run(){

            while (true) {
                synchronized (Window.class){//不能用this 下面有3个对象
                    //Window.class 只加载一次
                    if (ticket > 0) {
                        System.out.println(getName() + ":卖票，票号为" + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                }

            }

    }

}

class WindowR implements Runnable {
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        //Object obj = new Object(); 放这里是三把锁
            while (true) {
                synchronized (this) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                }
            }
        }

}

public class WindowTest {
    public static void main(String[] args) {
        WindowR wr = new WindowR();
//三个线程用的一个对象 一个ticket
        Thread t1 = new Thread(wr);
        Thread t2 = new Thread(wr);
        Thread t3 = new Thread(wr);



        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
