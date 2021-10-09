package ThreadDemo;

public class MyThread extends Thread {
    public void run()
    {
        for(int i=1;i<=100;i++)
            System.out.println("线程"+ getName()+ "正在打印" + i);
    }
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始执行……");
        MyThread thread = new MyThread();
        thread.start();
        for(int i = 1 ; i<=100;i++)
            System.out.println("线程" + name + "正在打印" + i);
        System.out.println(name + "执行完毕！");
    }
}


