package JavaBasic.Encapsulation;

public class MyObject extends test {
    public static void main(String[] args) throws CloneNotSupportedException {
        test test1 = new test ();
       // test1.clone();
//clone()方法来自于类test，因此该clone()方法可见性为包java.lang及其子类Test，
//由于类MyObject不在此范围内，因此不满足可见性，编译不通过。
        //属于在MyObject下面去用test对象访问test的pro方法，不可以

        MyObject myObject = new MyObject();
        myObject.clone();//继承的test的clone?这里的clone是属于myObject自己的方法

    }
}
