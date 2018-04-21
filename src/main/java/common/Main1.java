package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-18.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = null;
        HashMap<String, Integer> map = new HashMap<>();
        while ((string = scanner.nextLine()) != null) {
            if (!string.equals("-")) {
                String[] strings = string.split(" ");
                map.put(strings[0], Integer.valueOf(strings[1]));
            } else {
                break;
            }
        }

        while ((string = scanner.nextLine()) != null) {
            System.out.println(getId(map, string));
        }
    }

    public static int getId(HashMap<String, Integer> map, String path) {
        if (path == null || path.length() == 0 || map.isEmpty()) return 0;

        String key = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String regex = "^" + entry.getKey() + "($|/.+$)";
            if (path.matches(regex)) {
                if (key == null) key = entry.getKey();
                else if (entry.getKey().length() > key.length()) key = entry.getKey();
            }

        }
        if (key != null) return map.get(key);
        return 0;
    }

}
