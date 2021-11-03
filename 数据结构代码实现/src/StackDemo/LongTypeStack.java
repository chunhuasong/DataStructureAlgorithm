package StackDemo;

public class LongTypeStack {
    private int maxSize;
    private long[] stackArray;
    private int top;
    public LongTypeStack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    public void push(long j) {
        //stackArray[top++] = j; 错误写法 第一抛出的值是【-1】
        stackArray[++top] = j; //++i 先自增 再赋值
    }
    public long pop() {
        return stackArray[top--]; //i-- 先赋值，再自减
    }
    public long peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    public static void main(String[] args) {
        LongTypeStack theStack = new LongTypeStack(10);
        theStack.push(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(50);
        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
