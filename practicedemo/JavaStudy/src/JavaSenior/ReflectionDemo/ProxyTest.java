package JavaSenior.ReflectionDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static JavaSenior.ReflectionDemo.ProxyFactory.*;

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("=====通用方法一========");

    }
    public void method2(){
        System.out.println("=====通用方法二========");

    }
}

//        要想实现动态代理，需要解决的问题？
//        问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
//        问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 class ProxyFactory {
    //调用此方法 返回一个代理类的对象
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}
class MyInvocationHandler implements InvocationHandler{
//当我们通过代理类的对象调用方法a时，就会自动调用如下的方法：invoke（）
    //将被代理类要执行的方法a声明在invoke()中
    private Object obj;//使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();


        //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        Object returnValue = method.invoke(obj,args);

        util.method2();
        return  returnValue;
    }
}

public class ProxyTest{
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance 是一个代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //这个代理类对象也是反射构建 它调函数是用代理类对象中handler的invoke
        //proxyInstance.getBelief();
        proxyInstance.eat("麻辣烫");

        System.out.println("*****************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}