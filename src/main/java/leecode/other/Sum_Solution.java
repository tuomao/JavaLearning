package leecode.other;

/**
 * Created by tuomao on 2017-07-10.
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int num = n;
        boolean flag=(num!=0) && ((num+=Sum_Solution(n - 1)) !=0);
        return num;
    }
}
