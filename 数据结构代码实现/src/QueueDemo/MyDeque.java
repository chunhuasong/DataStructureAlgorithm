package QueueDemo;

import org.junit.Test;
import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {
    @Test
    public void test(){
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
        deque.offerLast(2);


    }
}
