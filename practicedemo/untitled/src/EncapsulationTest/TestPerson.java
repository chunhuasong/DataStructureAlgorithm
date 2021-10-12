package EncapsulationTest;

import Encapsulation.Father;
import Encapsulation.Son;

public class TestPerson extends Son {
    public static void main(String[] args) {

        TestPerson tom = new TestPerson();
        tom.name = "Tom";

        Son Tom = new Son();
       // Tom.name = "tom";//name是protected，
        // 它的可见性是Encapsulation包及Father的子类
        //但他不能访问基类中的protected变量

        Tom.setName("tom");

        Father L = new Father();
       // L.name="L";//不能访问基类中的protected变量



}

}
