package JavaSenior.ThreadDemo;
//1.定义子类，实现Runnable接口
public class RunnableThread implements Runnable{
    @Override
    //2.重写run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }


    public static void main(String[] args) {
        //3.创建实现类的对象
        RunnableThread rt1 = new RunnableThread();
        //4.将此对象作为参数传递到Thread的构造器中，创建Thread类的对象
        Thread t1 = new Thread(rt1);
        //通过Thread类的对象调用start()
        t1.start();

        Thread t2 = new Thread(rt1);

        t2.start();
    }
}
