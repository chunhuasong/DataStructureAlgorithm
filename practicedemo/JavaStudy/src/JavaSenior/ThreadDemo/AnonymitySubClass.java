package JavaSenior.ThreadDemo;

public class AnonymitySubClass extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i % 20 == 0)
                yield();//释放当前线程

        }

    }

    public AnonymitySubClass(String name) {
        super(name);
    }



         public static void main(String[] args) {
         AnonymitySubClass t1 = new AnonymitySubClass("t1");
            t1.start();

            new Thread(){
                public void run(){
                    for(int i = 0; i < 100; i++){
                        if(i % 2 != 0)
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                        if(i == 51) {
                            try {
                                t1.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }.start();

             }


    }
