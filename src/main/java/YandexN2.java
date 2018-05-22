import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class YandexN2 {

    public static List<String> meeting = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int nOfRequests = Integer.parseInt(n);
        int count = 0;

        while (count < nOfRequests) {
            String input = scanner.nextLine();
            if (input.contains("APPOINT")) {
                appoint(input.replaceAll("APPOINT ", ""));
            }
            if (input.contains("PRINT")) {
                print(input.replaceAll("PRINT ", ""));
            }
            count++;
        }
//        test();
    }

    private static class Meet {
        int dayOfMeeting;
        int startOfMeeting;
        int endOfMeet;
    }

    public static Meet getTimeAndDate(String input) {
        String[] infOfMeeting = input.split(" ");
        int hh = Integer.parseInt(infOfMeeting[1].substring(0, 2));
        int mm = Integer.parseInt(infOfMeeting[1].substring(3));
        int duration = Integer.parseInt(infOfMeeting[2]);
        Meet meet = new Meet();

        meet.dayOfMeeting = Integer.parseInt(infOfMeeting[0]);
        meet.startOfMeeting = hh * 60 + mm;
        meet.endOfMeet = meet.startOfMeeting + duration;
        return meet;
    }

    public static void appoint(String input) {
        boolean flag = true;
        Meet newMeeting = getTimeAndDate(input);
        Meet oldMeeting;
        for (String meet : meeting) {
            oldMeeting = getTimeAndDate(meet);
            if (newMeeting.dayOfMeeting == oldMeeting.dayOfMeeting) {
                if (!(newMeeting.startOfMeeting >= oldMeeting.endOfMeet || newMeeting.endOfMeet <= oldMeeting.startOfMeeting)) {
                    System.out.println("FAIL");
                    System.out.println(input.replaceAll(":", "").replaceAll("(\\d+ )*", ""));
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            meeting.add(input);
            System.out.println("OK");
        }
    }

    public static void print(String input) {
        Collections.sort(meeting);
        String[] inputParts = input.split(" ");
        for (String meet : meeting) {
            int gap = meet.indexOf(" ");
            if (inputParts[0].equals(meet.substring(0, gap)) && meet.contains(inputParts[1])) {
                System.out.println(meet.substring(gap + 1).replaceAll("( [1-9] )", " ").replaceAll("( 10 )", " "));
            }
        }
    }

    public static void test() {
        System.out.println();
        for (String r : meeting) {
            System.out.println(r);
        }
    }
}
