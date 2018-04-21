package leecode.other;

import org.junit.Test;

/**
 * Created by tuomao on 2017-07-10.
 */

/**
 * 参见牛客网讨论 “箫筱沐羽”的答案
 */
public class Add {
    public int Add(int num1,int num2) {
        int temp=0;
        while (num2!=0){
            temp= num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }

    @Test
    public void testAdd(){
        System.out.println(Add(1,2));
    }

}
