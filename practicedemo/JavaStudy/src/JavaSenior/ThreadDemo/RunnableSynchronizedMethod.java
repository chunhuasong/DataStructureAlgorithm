package JavaSenior.ThreadDemo;

class WindowR1 implements Runnable {
    private int ticket = 100;
    //Object obj = new Object();
    @Override
    public void run() {
        //Object obj = new Object(); 放这里是三把锁
        while (true) {
                show();
            }
        }

    private synchronized void show(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
            ticket--;
        }
    }
    }




public class RunnableSynchronizedMethod {

    public static void main(String[] args) {
        WindowR1 wr1 = new WindowR1();
//三个线程用的一个对象 一个ticket
        Thread t1 = new Thread(wr1);
        Thread t2 = new Thread(wr1);
        Thread t3 = new Thread(wr1);



        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
