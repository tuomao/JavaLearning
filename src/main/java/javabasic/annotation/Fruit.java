package javabasic.annotation;

/**
 * Created by tuomao on 2016/9/27.
 */
public class Fruit {

    @FruitColor(value = FruitColor.Color.RED)
    private int color;

    public Fruit(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
