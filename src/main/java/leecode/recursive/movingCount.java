package leecode.recursive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tuomao on 2017-07-13.
 */

/**
 *
 * 可以用递归，也可以用广度优先遍历搜索的算法
 *
 *
 */
public class movingCount {

    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0) return 0;
        int counter=0;
        Queue<List<Integer>> worklist=new LinkedList<>();
        List<Integer> item=new ArrayList<>(2);
        int[][] visited=new int[rows][cols];
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                visited[i][j]=0;
            }
        }
        worklist.add(item);
        item.add(0);
        item.add(0);
        visited[0][0]=1;

        while (!worklist.isEmpty()){

            counter++;
            item=worklist.poll();
            int x=item.get(0);
            int y=item.get(1);


            if(x-1>=0 && getNumber(x-1)+getNumber(y)<=threshold && visited[x-1][y]!=1) {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(x-1);
                temp.add(y);
                worklist.offer(temp);
                visited[x-1][y]=1;
            }
            if(x+1<rows && getNumber(x+1)+getNumber(y)<=threshold && visited[x+1][y]!=1) {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(x+1);
                temp.add(y);
                worklist.offer(temp);
                visited[x+1][y]=1;
            }
            if(y-1>=0 && getNumber(x)+getNumber(y-1)<=threshold && visited[x][y-1]!=1) {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(x);
                temp.add(y-1);
                worklist.offer(temp);
                visited[x][y-1]=1;
            }
            if(y+1<cols && getNumber(x)+getNumber(y+1)<=threshold && visited[x][y+1]!=1) {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(x);
                temp.add(y+1);
                worklist.offer(temp);
                visited[x][y+1]=1;
            }
        }
        return counter;
    }

    public int getNumber(int n){
        int sum=0;
        while (n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(movingCount(10,5,8));
    }
}
