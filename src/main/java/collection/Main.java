package collection;

/**
 * Created by tuomao on 2017-08-25.
 */

import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int maxMount(int price, int cap, int emptyBottle, int money) {
        if (money < price || price<=0) return 0;
        int emptyBottleNumber = 0;
        int sum = 0;
        int capNumber = 0;

        sum += money / price;

        emptyBottleNumber = sum;
        capNumber = sum;
        while (emptyBottleNumber >= emptyBottle || capNumber >= cap) {

            int temp = emptyBottleNumber / emptyBottle;
            temp += capNumber / cap;
            emptyBottleNumber = emptyBottleNumber % emptyBottle + temp;
            capNumber = capNumber % cap + temp;
            sum += temp;
        }

        return sum;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _price;
        _price = Integer.parseInt(in.nextLine().trim());

        int _cap;
        _cap = Integer.parseInt(in.nextLine().trim());

        int _emptyBottle;
        _emptyBottle = Integer.parseInt(in.nextLine().trim());

        int _money;
        _money = Integer.parseInt(in.nextLine().trim());

        res = maxMount(_price, _cap, _emptyBottle, _money);
        System.out.println(String.valueOf(res));

    }
}