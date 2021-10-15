package JavaSenior.ThreadDemo;

public class SingletonSynchronized {
}

class Bank {

    private Bank() {
    }

    private static Bank instance = null;

    //懒汉式
    public static Bank getInstance() {

//        //方式一：效率较差 每一个线程调用 都要先等，判断null,再get对象
//        synchronized (Bank.class) {
//            if (instance == null) {
//
//                instance = new Bank();
//            }
//            return instance;
//        }
//    方式二：效率稍高 前几个线程要等一下，后边的线程发现对象已经不是null可以get后直接走
        if(instance == null){
            synchronized (Bank.class){
                if (instance == null) {

                instance = new Bank();
            }
            }
        }
        return instance;
    }
}