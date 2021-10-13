package JavaBasic.class1;



public class Person {

    String name;
    private int age;
    /**
     * sex:1 表明是男性
     * sex:0 表明是女性
     */
    int sex;

    public void study(){
        System.out.println("studying");
    }

//    //public void showAge(){
//        System.out.println("age:" + age);
//    }

    public int addAge(int i){
        age = age + i;
        return age;
    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }
    public void setAge(int a)
    {
        age=a;
    }

    public Person(){
        age=18;
        name="Tom";
    }

    public static void main(String[] args) {
        Person p1 = new Person();



        p1.sex = 1;

        //p1.study();
        //p1.showAge();
        System.out.println(p1.getAge());
        System.out.println(p1.getName());
        int newAge = p1.addAge(2);
        System.out.println(p1.name + "的新年龄为：" + newAge);

        Person p2 = new Person();
        System.out.println(p2.getName());


        //p2.showAge();

    }
}




