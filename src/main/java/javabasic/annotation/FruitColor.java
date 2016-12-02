package javabasic.annotation;

import java.awt.*;
import java.lang.annotation.*;


/**
 * Created by tuomao on 2016/9/27.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    public enum Color{ BULE,RED,GREEN};

    public Color value() default Color.GREEN;

}
