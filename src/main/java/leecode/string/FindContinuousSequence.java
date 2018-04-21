package leecode.string;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-07-10.
 */

/**
 *
 *  1. 注意是连续数字
 *  2. 有n个数字，那么如果符合要求：  (sum-（n（n-1）/2）)%n==0
 *  3. 推理，设第一个数字为k，n个数字，那么 和为   nk+n（n-1）/2=sum  k必须为整数
 *  4. while的循环，需要sum-n*(n-1)/2>=n
 *
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        if(sum<=0){
            return results;
        }
        int n=2;
        int temp=0;
        while ( (temp=sum-n*(n-1)/2)>=n){
            if(temp%n==0){
                temp=temp/n;
                ArrayList<Integer> seq=new ArrayList<>();
                for(int i=temp;i<temp+n;i++) seq.add(i);
                results.add(0,seq);
            }
            n++;
        }

        return results;
    }

    @Test
    public void testFindContinuousSequence(){
        System.out.println(FindContinuousSequence(100));
        System.out.println(FindContinuousSequence(3));
    }
}
