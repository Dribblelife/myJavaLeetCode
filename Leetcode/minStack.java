package Leetcode;

import java.util.Stack;

public class minStack {//空间换取时间
    Stack<Integer> datastack;
    Stack<Integer> minStack;
    public minStack(){
        datastack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int x ){
        datastack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            if (x<minStack.peek()){
                minStack.push(x);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }
    public void pop(){
        datastack.pop();
        minStack.pop();
    }
    public int top(){
        return datastack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
