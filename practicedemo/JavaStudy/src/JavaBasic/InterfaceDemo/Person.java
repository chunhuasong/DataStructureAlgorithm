package JavaBasic.InterfaceDemo;

public class Person extends HumanStyle implements Runner,Swimmer{
    @Override
    public void run() {

        System.out.println(" running...");
    }

    @Override
    public Runner getrunner() {
        return null;
    }

    @Override
    public void swim() {
        System.out.println(" swimming...");
    }

    @Override
    public Runner get() {
        return null;
    }


}
