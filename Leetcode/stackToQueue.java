package Leetcode;

import java.util.Stack;

public class stackToQueue {
    Stack<Integer> stack;
    Stack<Integer> tmpStack;
    public stackToQueue(){
        stack = new Stack<Integer>();
    }
    public void push(int x){
        tmpStack = new Stack<Integer>();
        //先把原队列（队列中栈）的元素全部push出到临时栈，现在原本队头在栈底
        while (!stack.empty()){
            tmpStack.push(stack.pop());
        }
        tmpStack.push(x);
        while (!tmpStack.empty()){
            stack.push(tmpStack.pop());
        }
    }
    public int pop(){
        return stack.pop();
    }
    public int peek(){
        return stack.peek();
    }
    public boolean empty(){
        return stack.empty();
    }
}
