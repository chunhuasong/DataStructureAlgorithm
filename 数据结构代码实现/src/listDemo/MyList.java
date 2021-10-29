package listDemo;

import org.junit.Test;

public class MyList<E> implements List<E>{

    private Node<E> head;
    private Node<E> tail;
    int size;

    @Override
    public String toString() {
        return "MyList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Test
    public void test(){
        MyList<Integer> myList = new MyList<>();
        for(int i = 0;i < 10;i++){
            myList.add(i);
        }
        System.out.println(myList.set(4,19));
        System.out.println(myList.contains(2));
        System.out.println(myList.insert(1,20));
        System.out.println(myList.tail.next);
        myList.delete(10);
        for(int i = 0;i < myList.getSize();i++){
            System.out.println(myList.get(i).toString());
        }

    }

    @Test
    public void testLoop(){
        MyList<Integer> myList = new MyList<>();
        for(int i = 0;i < 10;i++){
            myList.addLoop(i);
        }
        System.out.println(myList.getSize());
        for(int i = 0;i < myList.getSize();i++){
            System.out.println(myList.get(i).toString());
        }

    }

    @Override
    public boolean add(E data) {
        //创建一个新节点
        Node<E> newNode = new Node<E>(data,null);
        Node<E> p = tail;

        //tail.next = newNode;
        // tail.next 空指针异常
        //新节点给尾部
        tail =  newNode;
        if(p == null){
            head = newNode;
        }
        else p.next = newNode;
        size++;


        return true;
    }

    public boolean addLoop(E data) {
        //创建一个新节点
        Node<E> newNode = new Node<E>(data,null);
        Node<E> p = tail;

        //tail.next = newNode;
        // tail.next 空指针异常
        //新节点给尾部
        tail =  newNode;
        tail.next = head;
        if(p == null){
            head = newNode;
        }
        else p.next = newNode;
        size++;


        return true;
    }

    @Override
    public boolean delete(int i) {
        Node<E> p = head;
        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else if(i == 1) {
            //删除头节点
            head = p.next;
            size--;
            return true;
        }
        else if(i == size){
            for(int j = 1;j < i-1;j++){
                p = p.next;
            }
            p.next = null;
            tail = p;
            size--;
            return true;
        }
        else {
            for(int j = 1;j < i-1;j++){
                p = p.next;
            }
            p.next = p.next.next;
            size--;
            return true;
        }


    }

    @Override
    public boolean insert(int i, E data) {
        Node<E> p = head;

        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else if( i == size){
            add(data);
            size++;
            return true;
        }
        else {
            for (int pos = 1;pos < i - 1;pos++){
                p = p.next;
            }
            Node<E> after = p.next;
            Node<E> newNode = new Node<>(data,after);
            p.next = newNode;
            size++;
            return true;
        }

    }

    @Override
    public boolean contains(E data) {
        Node<E> p = head;
        while (p != null){
            if(p.data == data){
                return true;
            }
            else {
                p = p.next;
            }
        }

        return false;
    }

    @Override
    public boolean set(int i, E data) {
        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else {
            int pos = 1;
            Node<E> p = head;
            for(;pos < i; pos++){
                p = p.next;

            }
            p.data= data;
            return true;
        }
    }

    @Override
    public E get(int i) {//获得第i个节点的值
        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else {
            int pos = 0;
            Node<E> p = head;
            for(;pos < i; pos++){
                p = p.next;
            }
            return p.data;
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String outOfBoundsMsg(int i) {
        return "Index: " + i + ", Size: " + size;
    }
}


class Node<E>{
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public Node(Node<E> next) {
        this.next = next;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

}



interface List<E>{
    boolean add(E data);
    boolean delete(int i);
    boolean insert(int i,E data);
    boolean contains(E data);
    boolean set(int i,E data);
    E get(int i);
    int getSize();
    void clear();
    String outOfBoundsMsg(int i);//输入的i越界

}

