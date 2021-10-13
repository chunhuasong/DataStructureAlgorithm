package JavaBasic.InterfaceDemo;
//▪ 定义一个接口用来实现两个对象的比较。
//▪ interface CompareObject
//{
//public int compareTo(Object o);
////若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
//}
//▪ 定义一个Circle类。
//▪ 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
//在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个
//圆的半径大小。
//▪ 定 义 一 个 测试 类 TestInterface ， 创建两个 ComparableCircle 对 象 ， 调 用
//compareTo方法比较两个类的半径大小。
//▪ 思考：参照上述做法定义矩形类Rectangle和ComparableRectangle类，在
//ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积
//大小。
public interface CompareObject {
    public int compareTo(Object o);

    public static  void output(){

    }

    static void method1(){

    }

}
