package common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-23.
 */
public class Main3 {

    static Queue<Point> points = new LinkedList<>();
    static int l = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        for (int i = 0; i < r; i++) {
            Point point = new Point();
            point.x = scanner.nextInt();
            point.y = scanner.nextInt();

            if (point.x >= 0 && point.x < m && point.y >= 0 && point.y < n) {
                System.out.print(addLand(point));
            } else {
                System.out.print(l);
            }
            if (i != r - 1) {
                System.out.print(" ");
            }
        }

    }

    public static int addLand(Point point) {
        int x, y;
        boolean flag = false;
        for (Point p : points) {
            if (p.x == point.x && p.y == point.y) {
                return l;
            }
            if ((p.x - 1 == point.x && p.y == point.y) ||
                    (p.x + 1 == point.x && p.y == point.y) ||
                    (p.x == point.x && p.y + 1 == point.y) ||
                    (p.x == point.x && p.y - 1 == point.y)) {
                flag = true;
                break;
            }
        }
        if (!flag) l++;
        points.add(point);
        return l;
    }

    public static class Point {
        public int x;
        public int y;
    }
}
