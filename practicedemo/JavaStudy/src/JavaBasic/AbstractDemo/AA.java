package JavaBasic.AbstractDemo;
//声明抽象类，并包含抽象方法。
// 测试类中创建一个继承抽象类的匿名子类的对象
    abstract class AA{
        public abstract void m();

        public static void main(String[] args) {
            AA a = new AA() {
                @Override
                public void m() {

                }
            };
        }
    }





