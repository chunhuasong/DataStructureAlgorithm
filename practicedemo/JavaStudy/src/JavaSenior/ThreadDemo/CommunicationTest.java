package JavaSenior.ThreadDemo;
//使用两个线程打印 1-100。线程1, 线程2 交替打印

class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){

            synchronized (this) {

                notify();

                if(number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    break;
                }
            }
        }

    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }






}
