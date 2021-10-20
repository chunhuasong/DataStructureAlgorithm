package JavaSenior.GenericDemo.exer1;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//创建 DAO 类的对象，
// 分别调用其 save、get、update、
// list、delete 方法来操作 User 对象，
//使用 Junit 单元测试类进行测试
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        //此时有NullPointerException
        //因为map没有初始化
        dao.save("1001",new User(1001,34,"jay"));
        dao.save("1002",new User(1002,20,"jolin"));
        dao.save("1003",new User(1001,25,"haha"));
        dao.update("1003",new User(1003,50,"FANG"));

        dao.delete("1002");
        //System.out.println(list);
        List<User> list = dao.list();
        list.forEach(System.out::println);



    }
}
