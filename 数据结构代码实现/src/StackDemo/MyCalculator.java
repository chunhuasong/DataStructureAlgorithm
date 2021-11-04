package StackDemo;

import org.junit.Test;

import java.util.Scanner;

//通过栈实现四则运算
public class MyCalculator {

        public int change(String formula){
            //初始化空栈
            //LongTypeStack NumStack = new LongTypeStack(formula.length());
            char[] format = new char[formula.length()];
            LongTypeStack SymbolStack = new LongTypeStack();
            //中缀表达式转化为后缀表达式

            for(int i = 0;i < formula.length();i++){
                if(formula.charAt(i) > '0' && formula.charAt(i) < '9'){
                    format[i] = formula.charAt(i);
                }
                else{
                    if(SymbolStack.isEmpty()){
                        SymbolStack.push(formula.charAt(i));
                    }
                    else{
                        char last = (char) SymbolStack.peek();
                        if(getPriority(last) > getPriority(formula.charAt(i))){

                        }

                    }

                }

            }
            return 0;
        }

    //获取字符c的优先级并返回
    private int getPriority(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '(':
                return 3;
            case ')':
                return -3;
            case '#':
                return -4;
            default:
                return -5;
        }
    }
        @Test
    public void test(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入算式");
            String formula = scanner.nextLine();

        }
}
