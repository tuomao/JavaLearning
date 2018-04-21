package leecode.printMatrix;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {

    /**
     *
     * @param matrix
     * @return
     *
     * 基本思路
     * 定义行走的左界，右界，上界，下界
     * 然后按照
     * 左=》右
     * 右=》下
     * 下=》左
     * 左=》上
     * 的顺下行走
     * 停止条件！！！
     * 只要其中有一个不能继续往下走了，那么就证明已经行走完了，需要马上结束！！！，能能放在while循环里面等待结束
     *
     *
     *
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int LEFT = 0, TOP = 0, RIGHT = matrix[0].length-1, BOTTOM =matrix.length-1;

        while (true){
            // 从左往右
            int i,j;
            i=TOP;
            for(j=LEFT;j<=RIGHT;j++){
                list.add(matrix[i][j]);
            }
            TOP++;
            if(TOP>BOTTOM){
                break;
            }
            // 从右往下
            j=RIGHT;
            for(i=TOP;i<=BOTTOM;i++){
                list.add(matrix[i][j]);
            }
            RIGHT--;

            if(RIGHT<LEFT){
                break;
            }
            // 从右往左
            i=BOTTOM;
            for(j=RIGHT;j>=LEFT;j--){
                list.add(matrix[i][j]);
            }
            BOTTOM--;
            if(BOTTOM<TOP){
                break;
            }
            // 从左往上
            j=LEFT;
            for(i=BOTTOM;i>=TOP;i--){
                list.add(matrix[i][j]);
            }
            LEFT++;
            if(LEFT>RIGHT){
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

//        int[][] matrix={{1},{2},{3},{4},{5}};
        ArrayList<Integer> list=new Solution().printMatrix(matrix);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
