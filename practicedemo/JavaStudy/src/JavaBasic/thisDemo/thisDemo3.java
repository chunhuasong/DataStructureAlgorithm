package JavaBasic.thisDemo;
//this()：调用当前类的构造函数this()构造函数调用可以用来调用当前类的构造函数。
// 它用于重用构造函数。 换句话说，它用于构造函数链接。
public class thisDemo3 {

//    //从参数化构造函数调用默认构造函数
//    thisDemo3(){
//        System.out.println("hello");
//    }
//    thisDemo3(int x){
//        this();
//        System.out.println(x);
//    }


//从默认构造函数调用参数化构造函数：
    thisDemo3(){
        this(5);
        System.out.println("hello");
    }
    thisDemo3(int x){
        System.out.println(x);
    }
    public static void main(String[] args) {
        thisDemo3 three = new thisDemo3();

    }
}
