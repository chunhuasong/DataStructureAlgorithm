package Encapsulation;

public class Father {
    protected String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Father ming = new Father();
        ming.name="MING";

    }
}


