import java.util.*;

public class Example {
    public static void main(String[] args) {
        int count = 0;
        String r = "world sasda world ";
        String f = "world";
        String t = "w";
        String g = "w ";

//        System.out.println(r.contains());
//        System.out.println(g.matches(t + "(\\w+)? "));
//        System.out.println(r.contains();
    }
    public static int counting(String input, int numberOfWords) {
        String[] words = input.split(" ");
        int count = words[0].length();
        int unic;
        boolean flag = true;
        for (int i = 1; i < numberOfWords; i++) {
            for (int j = 1; j < words[i].length(); j++) {
                String part = words[i].substring(0, j);
                unic = 0;
                for (int z = 0; z < i; z++) {
                    if (words[z].contains(part)) {
                        unic++;
                    }
                }
                if (unic == 1) {
                    count += j;
                    flag = false;
                    break;
                }

            }
            if (flag){
                count += words[i].length();
            }
        }

        return count;
    }
}
