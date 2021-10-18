package JavaSenior.CollectionDemo;

import java.util.Objects;

public class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    //按姓名从大到小排序
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            int compare = -this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }
            else {
                return Integer.compare(this.age,user.age);
            }

        }else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
