package javabasic.annotation;

import java.lang.reflect.Field;

/**
 * Created by tuomao on 2016/9/27.
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields) {
            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                System.out.println("fruit color is " + fruitColor.value());
            }
        }
    }
}
