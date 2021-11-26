package StackDemo;

public class ShareStack {
    private int top1;
    private int top2;
    private int maxSize;
    private long[] stackArray;
    //两栈为空时：top1在新栈的栈底 top2在栈顶
    public ShareStack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top1 = -1;
        top2 = s-1;
    }

    public void push(long j,int stackNum) {
        if(stackNum == 1){
            stackArray[++top1] = j;
        }
        if(stackNum == 2){
            stackArray[--top2] = j;
        }

    }
    public long pop(int stackNum) {
        if(stackNum == 1){
            return stackArray[top1--];
        }
        else {
            return stackArray[top2++];
        }

    }
    public boolean isFull() {
        return (top1+1 == top2);
    }
    public boolean isEmpty() {
        return (top1 == -1 | top2 == maxSize);
    }

    public static void main(String[] args) {
        ShareStack theStack = new ShareStack(10);
        theStack.push(10,1);
        theStack.push(20,1);
        theStack.push(30,2);
        theStack.push(40,2);
        theStack.push(50,2);
        while (!theStack.isEmpty()) {
            System.out.println("一栈");
            long value = theStack.pop(1);
            System.out.println(value);
            System.out.println("二栈");
            long value2 = theStack.pop(2);
            System.out.println(value2);

        }

    }
}
