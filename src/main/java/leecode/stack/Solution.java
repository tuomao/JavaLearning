package leecode.stack;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {


    private int base=0;
    private final int MAXSIZE=100;
    private int[] stack=new int[MAXSIZE];
    private int top=0;

    public void push(int node) {
        if(top<MAXSIZE){
            stack[top]=node;
            top++;
        }
    }

    public void pop() {
        if(top>base){
            top--;
        }
    }

    public int top() {
        return top;
    }

    public int min() {
        int min=stack[base];
        for(int i=base+1;i<top;i++){
            if(stack[i]<min){
                min=stack[i];
            }
        }
        return  min;
    }
}