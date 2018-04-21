package leecode.array;

import org.junit.Test;

/**
 * Created by tuomao on 2017-07-13.
 */
public class hasPath {
    int[] matrixPath;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows * cols > matrix.length || matrix.length == 0 || str == null || str.length == 0)
            return false;
        matrixPath = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hashPathCore(matrix, rows, cols, i, j, str, 0)) return true;
            }
        }
        return false;
    }

    public boolean hashPathCore1(char[] matrix, int rows, int cols, int i, int j, char[] str, int next) {
        int index;
        if (matrix[cols * i + j] != str[next]) return false;
        else {
            System.out.println("(" + i + "," + j + ")" + ":" + str[next]);
        }
        if (next == str.length - 1) return true;

        boolean result = false;

        matrixPath[cols * i + j] = 1;
        // 左边
        index = i * cols + j - 1;
        if (j - 1 >= 0 && matrixPath[index] != 1) {
            result = hashPathCore(matrix, rows, cols, i, j - 1, str, next + 1);
        }
        if (result) return true;

        // 上
        index = (i - 1) * cols + j;
        if (i - 1 >= 0 && matrixPath[index] != 1) {
            result = hashPathCore(matrix, rows, cols, i - 1, j, str, next + 1);
        }
        if (result) return true;

        // 右
        index = i * cols + j + 1;
        if (j + 1 < cols && matrixPath[index] != 1) {
            result = hashPathCore(matrix, rows, cols, i, j + 1, str, next + 1);
        }
        if (result) return true;

        // 下
        index = (i + 1) * cols + j;
        if (i + 1 < rows && matrixPath[index] != 1) {
            result = hashPathCore(matrix, rows, cols, i + 1, j, str, next + 1);
        }
        matrixPath[cols * i + j] = 0;
        if (result) return true;

        return false;
    }

    public boolean hashPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int next) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || matrixPath[i * cols + j] == 1 || matrix[cols * i + j] != str[next])
            return false;

        if (next == str.length - 1) return true;

        matrixPath[cols * i + j] = 1;
        boolean result = hashPathCore(matrix, rows, cols, i, j - 1, str, next + 1)
                || hashPathCore(matrix, rows, cols, i - 1, j, str, next + 1)
                || hashPathCore(matrix, rows, cols, i, j + 1, str, next + 1)
                || hashPathCore(matrix, rows, cols, i + 1, j, str, next + 1);
        matrixPath[cols * i + j] = 0;
        if (result) return true;
        return false;
    }

    @Test
    public void test() {

        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEMS".toCharArray()));
    }

}
