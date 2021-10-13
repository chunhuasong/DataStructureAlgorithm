package AbstractDemo;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("管理");
    }

    public static void main(String[] args) {
        Manager manager = new Manager("bob",123,678,955);
        manager.work();



    }
}
