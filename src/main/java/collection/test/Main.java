package collection.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] arr = new char[n][n];

        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = strings[i].charAt(j);
            }
        }

        System.out.println(iceNumber(arr));
    }

    public static int iceNumber(char[][] arr) {
        int[][] flag = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                flag[i][j] = 0;
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == '*' && flag[i][j] != 1) {
                    sum++;
                    Point point = new Point(i, j);
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(point);
                    flag[point.x][point.y]=1;

                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        int x1 = p.x;
                        int y1 = p.y;
                        int x2 = Math.min(arr.length - 1, p.x + 1);
                        int y2 = Math.min(arr.length - 1, p.y + 1);
                        for(int r=x1;r<=x2;r++){
                            for(int s=y1;s<=y2;s++){
                                if(  flag[r][s] !=1 && arr[r][s]=='*'){
                                    queue.add(new Point(r,s));
//                                    System.out.println("find new point ("+r+","+s+")");
                                    flag[r][s]=1;
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
        return sum;
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
