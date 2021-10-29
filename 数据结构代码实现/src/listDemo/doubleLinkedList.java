package listDemo;

public class doubleLinkedList<E> implements List<E>{
    @Override
    public boolean add(E data) {
        return false;
    }

    @Override
    public boolean delete(int i) {
        return false;
    }

    @Override
    public boolean insert(int i, E data) {
        return false;
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
    public E get(int i) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String outOfBoundsMsg(int i) {
        return null;
    }
}

class NodeDouble<E>{
    E data;
    NodeDouble<E> pre;
    NodeDouble<E> next;



}
