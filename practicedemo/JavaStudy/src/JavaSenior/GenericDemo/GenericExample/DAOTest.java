package JavaSenior.GenericDemo.GenericExample;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO stu1 = new StudentDAO();
        stu1.add(new Student());
        List<Student> list1 = stu1.getForList(10);
    }
}
