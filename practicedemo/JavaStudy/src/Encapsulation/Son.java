package Encapsulation;

import EncapsulationTest.TestPerson;

public class Son extends Father {

    public static void main(String[] args) throws CloneNotSupportedException {
        Father andy = new Father();
        andy.name = "Andy";

        Son ROSS = new Son();
        ROSS.name = "ROSS";
    }
}
