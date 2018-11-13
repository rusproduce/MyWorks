import java.util.*;

public class Example {
    public static void main(String[] args) {
        int r = 2140000000;
        System.out.println(r);
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
            if (flag) {
                count += words[i].length();
            }
        }

        return count;
    }
}


//   if (input.contains("APPOINT")) {
//           if (meets.isEmpty()) {
//           meets.add(new Meet(input.replaceAll("APPOINT ", "")));
//           System.out.println("OK");
//           } else {
//           Meet newMeet = new Meet(input.replaceAll("APPOINT ", ""));
////                    if (meets.stream().anyMatch(meet -> meet.crossCheck(newMeet.getDay(), newMeet.getStart(), newMeet.getEnd()))) {
//
//           if (meets.stream().anyMatch(meet -> meet.appoint(newMeet.getDay(), newMeet.getStart(), newMeet.getEnd(), name))) {
//           System.out.println("FAIL");
//           for (String name : newMeet.people) {
//           meets.stream().anyMatch(meet -> meet.appoint(newMeet.getDay(), newMeet.getStart(), newMeet.getEnd(), name));
//           }
//           System.out.println();
//           Meet.space = "";
////                    }
//           }
//           else {
//           meets.add(newMeet);
//           System.out.println("OK");
//           }