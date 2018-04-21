package niuker;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tuomao on 2017-06-05.
 */
public class Main {
    private Stack<Integer> stack=new Stack<>();
    private int[] counter;

    public boolean isValidSerialization(String preorder) {
        // code here
        String[] strings=preorder.split(",");
//        System.out.println(strings);
        counter=new int[strings.length];
        stack.clear();
        for(int i=0;i<counter.length;i++){
            counter[i]=0;
        }
        int i=0;
        while (i<strings.length){
            if(!(strings[i].equals("#"))){
                stack.push(i);
                System.out.println("push"+ strings[i]);
            }else{
                while (true){
                    if(!stack.isEmpty()) {
                        int index = stack.lastElement();
                        counter[index]++;
                        if (counter[index] == 2) {
                            stack.pop();
                            System.out.println("pop"+strings[index]);
                        } else {
                            break;
                        }
                    }else {
                        if(i==strings.length-1){
                            return true;
                        }
                        return  false;
                    }
                }

            }
            i++;
        }

        if(stack.isEmpty()){
            return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        String preorder = jin.next();
        System.out.println(new Main().isValidSerialization(preorder));
    }
}
