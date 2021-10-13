package JavaSenior.ThreadDemo;

public class DeadThreadTest extends Thread {

    public void run(){
        for (int i=1 ; i<=3 ;i++){
            System.out.println("正在执行线程。。。");

        }
        try{
            sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeadThreadTest thread = new DeadThreadTest();
        System.out.println("未启动的线程"+(thread.isAlive()?"正在活动":"没有活动"));
        thread.start();
        System.out.println("已启动的线程"+(thread.isAlive()?"正在活动":"没有活动"));
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("已终止的线程"+(thread.isAlive()?"正在活动":"没有活动"));
    }
}
