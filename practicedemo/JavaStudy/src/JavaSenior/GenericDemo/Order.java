package JavaSenior.GenericDemo;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    String orderName;
    int orderId;

    T orderT;

    public Order(){};


    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
//如下不是泛型方法
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //静态方法中，不能使用类的泛型。因为静态方法加载早于类的实例化，这个类还没实例化。

//    public static T show(T tmp){
//        return tmp;
//    }
    //泛型方法：方法中出现泛型结构，泛型参数与类的泛型参数没有任何关系。
    //泛型方法所属的类是不是泛型类没有关系
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e: arr){
            list.add(e);
        }
        return list;

    }
}
