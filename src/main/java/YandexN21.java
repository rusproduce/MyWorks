import java.util.*;

public class YandexN21 {
    public static List<Meet> meets = new ArrayList<>();

    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int nOfRequests = Integer.parseInt(n);
        int count = 0;
        while (count < nOfRequests) {
            String input = scanner.nextLine();
            if (input.contains("APPOINT")) {
                Meet newMeet = new Meet(input.replaceAll("APPOINT ", ""));
                for (String name : newMeet.people) {
                    if (meets.stream().anyMatch(meet -> meet.appoint(newMeet.getDay(), newMeet.getStart(), newMeet.getEnd(), name))) {
                        flag = false;
                    }
                }
                if (flag) {
                    meets.add(newMeet);
                    System.out.println("OK");
                } else {
                    Meet.space = "";
                    System.out.println();
                    flag = true;
                }
            } else {
                String[] inf = input.replaceAll("PRINT ", "").split(" ");
                int day = Integer.parseInt(inf[0]);
                Collections.sort(meets);
                meets.forEach(meet -> meet.print(day, inf[1]));
            }
            count++;
        }
    }

    private static class Meet implements Comparable<Meet> {
        private int day;
        private String time;
        private int during;
        private int n;
        private List<String> people;
        private int start;
        private int end;
        private static String space = "";

        public Meet(String input) {
            String[] infOfMeeting = input.split(" ");
            day = Integer.parseInt(infOfMeeting[0]);
            time = infOfMeeting[1];
            during = Integer.parseInt(infOfMeeting[2]);
            n = Integer.parseInt(infOfMeeting[3]);
            people = new ArrayList<>();
            for (int i = 4; i < infOfMeeting.length; i++) {
                this.people.add(infOfMeeting[i]);
            }
            start = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            end = start + during;
        }

        public void print(int day, String name) {
            if (this.day == day && people.contains(name)) {
                System.out.print(time + " " + during);
                for (String man : people) {
                    System.out.print(" " + man);
                }
                System.out.println();
            }
        }

        public boolean appoint(int day, int start, int end, String name) {
            if (this.day == day && !(this.start >= end || this.end <= start) && people.contains(name)) {
                if (space.isEmpty()) {
                    System.out.println("FAIL");
                    System.out.print(space + name);
                    space = " ";
                } else {
                    System.out.print(space + name);
                }
                return true;
            }
            return false;
        }

        public int getDay() {
            return day;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Meet o) {
            int flag = this.day - o.day;
            if (flag == 0) {
                flag = this.start - o.start;
            }
            return flag;
        }
    }

}
