package JavaSenior.GenericDemo.GenericExample;

import java.util.List;

//DAO: Data Access Object 数据访问对象
public class DAO<T> {//表的共性DAO

    //insert
    public void add(T t){

    }
    //delete
    public void remove(T t){

    }

    //update
    public void update(int index, T t){

    }

    //select one

    public T getIndex(int index){
        return null;
    }

    //select some
    public List<T> getForList(int index){
        return null;
    }

    //例子：获取表中有多少条记录？---long
    //入职时间====date
    public <E> E getvalue(){
        return null;
    }

}
