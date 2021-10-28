package listDemo;

public class MyList {


}


class Node<E>{
    E data;
    Node<E> next;

    public Node(Node<E> next) {
        this.next = next;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

}