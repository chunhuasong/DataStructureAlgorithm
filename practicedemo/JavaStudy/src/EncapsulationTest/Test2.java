package EncapsulationTest;

import Encapsulation.MyObject;
import Encapsulation.test;

public class Test2 extends MyObject {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyObject myObject = new MyObject();
        //myObject.clone();//可见性为包Encapsulation及MyObject的子类，虽然Test2是MyObject的子类，
        // 但在Test2中不能访问基类MyObject的protected方法clone()

        Test2 test2 = new Test2 ();
        test2.clone();
    }
}
