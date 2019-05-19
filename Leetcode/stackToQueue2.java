package Leetcode;

import java.util.Stack;

public class stackToQueue2 {
    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();
    public class myQueue{
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
    }
    public void push(int x ){
        inputStack.push(x);
    }
    public int pop(){
        adjust();//先调整操作，再进行pop
        int x = outputStack.peek();//先记录下栈顶元素
        outputStack.pop();//栈顶元素出栈
        return x;
    }
    public int peek(){
        adjust();
        return outputStack.peek();
    }
    public boolean empty(){
        return (inputStack.isEmpty()&&outputStack.isEmpty());
    }
    private void adjust(){
        if (!outputStack.isEmpty()){//当out栈不为空的时候，直接返回，不做调整
            return;
        }
        while (!inputStack.isEmpty()){//否则，将input栈中元素全部push到out栈中，知道input栈为空
            outputStack.push(inputStack.peek());
            inputStack.pop();
        }
    }
}
