package leecode.stack;

/**
 * Created by tuomao on 2017-07-13.
 */
public class MinStack {

    private final int MAXSIZE=100;
    private int[] stack=new int[MAXSIZE];
    private int top=-1;
    private int[] minStack=new int[MAXSIZE];
    private int minTop=-1;
    private Integer min=null;

    public void push(int ele) {
        if(top<MAXSIZE){
            if(min==null) {
                min=ele;
                top++;
                stack[top]=ele;
                minTop++;
                minStack[minTop]=ele;
            }else {
                if(ele<min) {
                    min=ele;
                    top++;
                    stack[top]=ele;
                    minTop++;
                    minStack[minTop]=ele;
                }else {
                    top++;
                    stack[top]=ele;
                }
            }
        }
    }

    public void pop(){
        if(top>=0){
            int ele=stack[top];
            top--;
            if(min!=null && ele==min){
                minTop--;
                if(minTop>=0){
                    min=minStack[minTop];
                }else {
                    min=null;
                }
            }
        }
    }

    public int min() {
        return  min;
    }
}
