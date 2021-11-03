package listDemo;

import org.junit.Test;

public class doubleLinkedList<E> implements List<E>{

    private NodeDouble<E> head;
    private NodeDouble<E> tail;
    int size;

    @Test
    public void test(){
        doubleLinkedList doubleLinkedList = new doubleLinkedList<Integer>();
        for(int i = 0;i < 10;i++){
            doubleLinkedList.add(i);
        }
        for(int i = 0;i < doubleLinkedList.getSize();i++){
            System.out.println(doubleLinkedList.get(i).toString());
        }
        System.out.println("******反向遍历**");
        for(int i = doubleLinkedList.getSize()-1;i >= 0;i--){
            System.out.println(doubleLinkedList.getReverse(i).toString());
        }
        System.out.println("******插入********");
        doubleLinkedList.insert(10,50);
        for(int i = doubleLinkedList.getSize()-1;i >= 0;i--){
            System.out.println(doubleLinkedList.getReverse(i).toString());
        }

        System.out.println("******删除********");
        doubleLinkedList.delete(10);
        for(int i = doubleLinkedList.getSize()-1;i >= 0;i--){
            System.out.println(doubleLinkedList.getReverse(i).toString());
        }
    }

    @Override
    public boolean add(E data) {

        if( head == null){
            head = new NodeDouble<>(data,null,null);
            tail = head;
        }
        else {
            NodeDouble newNode = new NodeDouble<E>(data,tail,null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;

    }

    @Override
    public boolean delete(int i) {

        NodeDouble<E> p = head;
        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else if(i == size){
            p = tail;
            tail = tail.pre;
            tail.next = null;
            size--;
            return true;
        }
        else if(i == 1){
            head = head.next;
            if(head != null){
                head.pre = null;
            }
            size--;
            return true;
        }
        else {
            for(int pos = 0;pos < i - 1;pos++){
                p = p.next;
            }
            NodeDouble<E> after = p.next;
            after.pre = p.pre;
            p.pre.next = after;
            size--;
            return true;
        }

    }

    @Override
    public boolean insert(int i, E data) {

        NodeDouble<E> p = head;

        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else if(i == size){
            add(data);

            return true;
        }
        else{
            for(int pos = 0;pos < i - 1;pos++){
                p = p.next;
            }
            NodeDouble<E> after = p.next;
//            //正确
//            NodeDouble<E> newNode = new NodeDouble<>(data,null,after);//先搞定新节点后继
//            after.pre = newNode;
//            //前继
//            p.next = newNode;
//            newNode.pre = p;
            NodeDouble<E> newNode = new NodeDouble<>(data,p,after);
            p.next = newNode;
            after.pre = newNode;
            size++;
            return true;
        }

    }

    @Override
    public boolean contains(E data) {
        return false;
    }

    @Override
    public boolean set(int i, E data) {
        return false;
    }

    @Override
    public E get(int i) {//获得第i个节点的值
        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else {
            int pos = 0;
            NodeDouble<E> p = head;
            for(;pos < i; pos++){
                p = p.next;
            }
            return p.data;
        }

    }

    public E getReverse(int i){
        //反向获取
        if(i<0 | i>size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(i));
        }
        else {
            int pos = size;
            NodeDouble<E> p = tail;
            for(;pos > i + 1; pos--){
                p = p.pre;
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

    }

    @Override
    public String outOfBoundsMsg(int i) {
        return "Index: " + i + ", Size: " + size;
    }
}


class NodeDouble<E>{
    E data;
    NodeDouble<E> pre;
    NodeDouble<E> next;

    public NodeDouble(E data, NodeDouble<E> pre, NodeDouble<E> next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public NodeDouble() {
    }
}
