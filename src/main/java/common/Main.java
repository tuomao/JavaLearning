package common;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = null;

        string = scanner.nextLine();
        System.out.println(parseString(string));


    }

    public static String parseString(String string) {
        if (string == null || string.length() == 0) return "__";
        StringBuffer buffer = new StringBuffer();
        buffer.append("_");
        int i = 0;
        while (i < string.length()) {
            if (string.charAt(i) == '.') {
                i++;
                continue;
            } else if (Character.isDigit(string.charAt(i))) {
                while (i < string.length() && Character.isDigit(string.charAt(i))) {
                    buffer.append(string.charAt(i));
                    i++;
                }
            } else if (Character.isLowerCase(string.charAt(i))) {
                while (i < string.length() && Character.isLowerCase(string.charAt(i))) {
                    buffer.append(string.charAt(i));
                    i++;
                }
            } else if (Character.isUpperCase(string.charAt(i))) {
                buffer.append(string.charAt(i));
                i++;
                if (Character.isUpperCase(string.charAt(i))) {
                    while (i < string.length() && Character.isUpperCase(string.charAt(i))) {
                        buffer.append(string.charAt(i));
                        i++;
                    }
                    if (i < string.length() && Character.isLowerCase(string.charAt(i))) {
                        i--;
                        buffer.deleteCharAt(buffer.length() - 1);
                    }
                } else if (Character.isLowerCase(string.charAt(i))) {
                    while (i < string.length() && Character.isLowerCase(string.charAt(i))) {
                        buffer.append(string.charAt(i));
                        i++;
                    }
                }
            }
            buffer.append("_");

        }
        return buffer.toString().toUpperCase();

    }
}
