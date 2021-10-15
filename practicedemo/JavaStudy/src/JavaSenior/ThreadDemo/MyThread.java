package JavaSenior.ThreadDemo;
//1.创建个子类继承Thread
public class MyThread extends Thread {

    //2.重写子类run()
    public void run()
    {
        for(int i=1;i<=100;i++)
            System.out.println("线程"+ getName()+ "正在打印" + i);
    }
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始执行……");
        //3.创建Thread子类对象
        MyThread thread = new MyThread();
        //4.通过此对象调用start（）
        thread.start();
        for(int i = 1 ; i<=100;i++)
            System.out.println("线程" + name + "正在打印" + i);
        System.out.println(name + "执行完毕！");
    }
}


