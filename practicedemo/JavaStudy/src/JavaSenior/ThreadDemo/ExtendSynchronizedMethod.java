package JavaSenior.ThreadDemo;


//继承用同步方法解决安全问题
class WindowE extends Thread{
    private static int ticket = 100;//静态共享一个变量
    private static Object object = new Object();
    @Override
    public void run(){

        while (true) {
          show();

        }

    }

    private static synchronized void show(){
      //同步監視器this 这个不安全a 写成静态 同步锁：WindowE.class
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
            ticket--;
        }
    }
}







public class ExtendSynchronizedMethod {
    public static void main(String[] args) {

//三个线程用的一个对象 一个ticket
        Thread t1 = new WindowE();
        Thread t2 = new WindowE();
        Thread t3 = new WindowE();



        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


