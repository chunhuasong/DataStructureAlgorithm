package StackDemo;
import java.util.*;

public class MyStack<E> implements Operation<E>{
     private int top;
     //top=0 代表有一个元素 top=-1代表空栈
     private int maxSize;


     private Stack<E> stack;
    public MyStack(int maxSize,E[] stack) {
        top = -1;
        this.maxSize = maxSize;

    }


    @Override
    public boolean InitStack(int size) {

        //MyStack<E> myStack =  new MyStack<>(size);


        return false;
    }

    @Override
    public boolean DestroyStack() {
        return false;
    }

    @Override
    public boolean ClearStack() {
        return false;
    }

    @Override
    public boolean isStackEmpty() {
        if(top == -1)
            return true;
        else
            return false;
    }

    @Override
    public E GetTop(MyStack<E> myStack) {

        return null;
    }


    @Override
    public E Push(E e) {
        return null;
    }

    @Override
    public E Pop() {
        return null;
    }

    @Override
    public int StackLength() {
        return 0;
    }





}



interface Operation<E>{
    boolean InitStack(int size);
    boolean DestroyStack();
    boolean ClearStack();
    boolean isStackEmpty();
    E GetTop(MyStack<E> myStack);
    E Push(E e);
    E Pop();
    int StackLength();
}


