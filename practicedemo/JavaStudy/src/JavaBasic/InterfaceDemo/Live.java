package JavaBasic.InterfaceDemo;

public class Live {
    public static void main(String args[]){
        Live t = new Live();
        Person p = new Person();
        t.m1(p);
        t.m2(p);
        t.m3(p);

        Runner r = p.getrunner();
    }
    public void  m1(Runner f) {
        f.run();
    }
    public void  m2(Swimmer s) {

        s.swim();
    }
    public void  m3(HumanStyle a) {

        a.truth();
    }
}
