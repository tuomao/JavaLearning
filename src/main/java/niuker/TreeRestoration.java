package niuker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-03-31.
 */
public class TreeRestoration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nodeNumber;
            int depth;
            int leafNumber;
            ArrayList<ArrayList<Integer>> dNodes = new ArrayList<>();// 每一层的节点的情况
            int[] dNodeNumber;
            ArrayList<Integer> leafNodes = new ArrayList<>();// 保存所有的叶子节点

            // 输入第一行的数
            nodeNumber = scanner.nextInt();
            depth = scanner.nextInt();
            leafNumber = scanner.nextInt();

            dNodeNumber = new int[depth + 1];
            // 输入每一个节点个数
            for (int i = 1; i <= depth; i++) {
                dNodeNumber[i] = scanner.nextInt();
            }

            // 输入每一层节点情况
            for (int i = 1; i <= depth; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 1; j <= dNodeNumber[i]; j++) {
                    list.add(scanner.nextInt());
                }
                dNodes.add(list);
            }
            for (int i = 0; i < leafNumber; i++) {
                leafNodes.add(scanner.nextInt());
            }

            int[][] nodeDistance = new int[nodeNumber + 1][nodeNumber + 1];// 记录任意两个节点之间的距离
            for (int i = 0; i < leafNumber; i++) {
                for (int j = 0; j < leafNumber; j++) {
                    nodeDistance[leafNodes.get(i)][leafNodes.get(j)] = scanner.nextInt();
                }
            }

//            showDistance(nodeDistance);

            ArrayList<Integer>[] nChilds = new ArrayList[nodeNumber + 1];// 记录每一个节点对应的孩子节点
            for (int i = 0; i <= nodeNumber; i++) {
                nChilds[i] = new ArrayList<>();
            }
            int[] nParent = new int[nodeNumber + 1];// 记录每一个节点的父亲节点
            nParent[1] = 0;

            for (int i = depth; i > 1; i--) {
                ArrayList<Integer> curNodes = dNodes.get(i - 1);
                ArrayList<Integer> parNodes = dNodes.get(i - 2);
                int parIndex = parNodes.size() - 1;
                while (leafNodes.contains(parNodes.get(parIndex))) {
                    parIndex--;
                }
                // 将最优一个节点的父亲节点指向上一层最后一个非叶子节点
                int j = curNodes.size() - 1;
                nParent[curNodes.get(j)] = parNodes.get(parIndex);
                nChilds[parNodes.get(parIndex)]
                        .add(curNodes.get(j));
                j--;
                // 计算当前层的父亲的节点
                for (; j >= 0; j--) {

                    if (nodeDistance[curNodes.get(j)][curNodes.get(j + 1)] == 2) {// 距离为2，则证明是同一个父亲

                    } else {// >2 ，则父亲必定是前一个非叶子节点
                        parIndex--;
                        // 找到前一个非叶子节点
                        while (leafNodes.contains(parNodes.get(parIndex))) {
                            parIndex--;
                        }
                    }
                    nParent[curNodes.get(j)] = parNodes.get(parIndex);
                    nChilds[parNodes.get(parIndex)]
                            .add(curNodes.get(j));
                }

                // 计算当前层任意两个节点之间的距离
                for (int o = 0; o < parNodes.size() - 1; o++) {
                    for (int p = o + 1; p < parNodes.size(); p++) {
                        int node1 = parNodes.get(o);
                        int node2 = parNodes.get(p);
                        if (nodeDistance[node1][node2] == 0) {

                            // 左边节点为叶子节点 右边节点一定不为叶子节点
                            if (leafNodes.contains(node1)) {
                                nodeDistance[node1][node2] = nodeDistance[node1][nChilds[node2].get(0)] - 1;

                            } else if (leafNodes.contains(node2)) {
                                nodeDistance[node1][node2] = nodeDistance[nChilds[node1].get(0)][node2] - 1;

                            } else {
                                nodeDistance[node1][node2] = nodeDistance[nChilds[node1].get(0)][nChilds[node2].get(0)] - 2;
                            }
                            nodeDistance[node2][node1] = nodeDistance[node1][node2];
                        }
                    }
                }
            }

            for (int i = 1; i <= nodeNumber; i++) {
                System.out.print(nParent[i] + " ");
            }
            System.out.println();
        }
    }

    public static void showDistance(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i < matrix.length; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
