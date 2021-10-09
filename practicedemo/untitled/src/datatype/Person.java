package datatype;

import java.util.Date;

public class Person {
    public String name;
    public int age;
    public Date birthDate;
    public String getInfo(){
        return "name:"+name+"age:"+age;

    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}


