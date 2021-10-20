package JavaSenior.ThreadDemo;
//生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
//取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
//生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
//知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
//果店中有产品了再通知消费者来取走产品。
//这里可能出现两个问题：
//生产者比消费者快时，消费者会漏掉一些数据没有取到。
//消费者比生产者快时，消费者会取相同的数据。

//多线程：生产者线程，消费者线程
//共享数据：店员（产品数量）
//线程安全？ 同步机制
//线程通信？是

class Clerk{

    private int productCount = 0;

    public synchronized void produceProduct() throws InterruptedException {

        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() +"：开始生产第" + productCount +"个产品");
            notify();//生产了就可以唤醒消费者
        }else{
            wait();
        }


    }

    public synchronized void consumeProduct() {

        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() +"：开始消费第" + productCount +"个产品");
            productCount--;
            notify();//消费过就可以唤醒生产者
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产产品……");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.produceProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{

    private Clerk clerk;


    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品……");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者");
        c1.setName("消费者");
        p1.start();
        c1.start();

    }
}