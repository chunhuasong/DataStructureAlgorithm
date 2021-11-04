package JavaSenior.ThreadDemo;
//哲学家就餐问题是在计算机科学中的一个经典问题，用来演示在并行计算中多线程同步(Synchronization)时产生的问题。
//有五个哲学家，他们共用一张圆桌，分别坐在五张椅子上。
// 在圆桌上有五个碗和五支筷子，平时一个哲学家进行思考，饥饿时便试图取用其左、右最靠近他的筷子，只有在他拿到两支筷子时才能进餐。
// 进餐完毕，放下筷子又继续思考。


import org.junit.Test;

//每一个哲学家都持有左边的筷子取去取右边的筷子，到第五个人的时候，他需要获取的右边筷子是第一个哲学家左手的筷子，最终形成死锁。
public class PhilosopherThread extends Thread {

    private Chopsticks left;

    private Chopsticks right;

    private int index;

    public PhilosopherThread(Chopsticks left, Chopsticks right, int index) {
        this.left = left;
        this.index = index;
        this.right = right;
    }

    @Override
    public void run() {
        synchronized (left) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(index + "等待获取筷子RIGHT进行吃饭");
            synchronized (right) {
                System.out.println(index + "获取筷子RIGHT进行吃饭");
            }
        }



    }

    public static void main(String[] args) {
        Chopsticks chopsticks1 = new Chopsticks();
        Chopsticks chopsticks2 = new Chopsticks();
        Chopsticks chopsticks3 = new Chopsticks();
        Chopsticks chopsticks4 = new Chopsticks();
        Chopsticks chopsticks5 = new Chopsticks();

        PhilosopherThread philosopherThread1 = new PhilosopherThread(chopsticks1, chopsticks2, 1);
        PhilosopherThread philosopherThread2 = new PhilosopherThread(chopsticks2, chopsticks3, 2);
        PhilosopherThread philosopherThread3 = new PhilosopherThread(chopsticks3, chopsticks4, 3);
        PhilosopherThread philosopherThread4 = new PhilosopherThread(chopsticks4, chopsticks5, 4);
        //让最后一个哲学家 先拿右再拿左 破坏了 先拿左等待右 循环等待的条件
        PhilosopherThread philosopherThread5 = new PhilosopherThread(chopsticks1, chopsticks5, 5);
        philosopherThread1.start();
        philosopherThread2.start();
        philosopherThread3.start();
        philosopherThread4.start();
        philosopherThread5.start();
    }


}

class Chopsticks{

}

