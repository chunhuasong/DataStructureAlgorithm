package JavaBasic.thisDemo;

public class thisDemo3_2 {
    int no;
    String name,course;
    float fee;

    thisDemo3_2(int no,String name,String course){
        this.no = no;
        this.name = name;
        this.course = course;
    }

    thisDemo3_2(int no,String name,String course,float fee){
        this(no, name, course);//必须在第一行
        this.fee=fee;

    }

    void display() {
        System.out.println(no + " " + name + " " + course + " " + fee);
    }

    public static void main(String[] args) {
        thisDemo3_2 thirtytwo = new thisDemo3_2(11,"andy","java",600f);
        thirtytwo.display();
    }

}
