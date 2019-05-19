package Leetcode;

import java.util.Stack;

public class validateStackTest {
    public boolean StackSequences(int[] pushed,int[] popped){
        Stack<Integer> stack=new Stack<>();
        for(int i=0,j=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek().equals(popped[j])){
                stack.pop();
                j++;
            }
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }
}
