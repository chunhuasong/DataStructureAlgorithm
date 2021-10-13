package JavaBasic.gaojileitexing;

public class jingtai {
    static class Person{
        private int id;
        public static int total=0;
        public Person(){
            total++;
            id=total;
        }

        public static void main(String[] args) {
            Person Tom= new Person();
            Tom.id=0;
            total=100;//不用创建对象就可以访问静态成员

            Person.total=100;
            System.out.println(Person.total);

            Person c = new Person();
            System.out.println(c.total);
        }

    }
}
