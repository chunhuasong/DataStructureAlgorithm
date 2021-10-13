package JavaBasic.InterfaceDemo;

public class Person extends HumanStyle implements Runner,Swimmer{
    @Override
    public void run() {

        System.out.println(" running...");
    }

    @Override
    public void swim() {
        System.out.println(" swimming...");
    }

}
