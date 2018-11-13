//import java.util.*;
//
//public class YandexN21 {
//    public static List<Meet> meets = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String n = scanner.nextLine();
//        int nOfRequests = Integer.parseInt(n);
//        int count = 0;
//        meets.add(new Meet("1 12:30 30 2 andrey 1alex gfds"));
//        meets.add(new Meet("2 12:00 30 2 andrey 2alex gfds"));
//        meets.add(new Meet("2 12:30 30 2 andrey 2alex"));
//        meets.add(new Meet("1 12:00 30 2 andrey 1alex"));
//        meets.add(new Meet("1 13:30 30 2 andrey alex"));
//        meets.add(new Meet("1 15:30 30 2 gfds alex"));
//        meets.add(new Meet("1 18:60 30 2 andrey alex"));
//        meets.add(new Meet("1 17:40 30 2 andrey alex gfds"));
//        meets.add(new Meet("2 14:30 30 2 andrey alex gfds"));
//        meets.add(new Meet("1 19:50 70 3 andrey alex gfds"));
//        while (count < nOfRequests) {
//            String input = scanner.nextLine();
//            if (input.contains("APPOINT")) {
//                if (meets.isEmpty()) {
//                    meets.add(new Meet(input.replaceAll("APPOINT ", "")));
//                    System.out.println("OK");
//                } else {
//                    Meet newMeet = new Meet(input.replaceAll("APPOINT ", ""));
//                    if (meets.stream().anyMatch(meet -> meet.crossCheck(newMeet.getDay(), newMeet.getStart(), newMeet.getEnd()))) {
//                        System.out.println("FAIL");
//                        for (String name : newMeet.people) {
//                            meets.stream().filter(meet -> meet.getDay() == ).(meet -> meet.appoint(newMeet.getDay(), newMeet.getStart(), newMeet.getEnd(), name));
//                        }
//                        System.out.println();
//                        Meet.space = "";
//                    } else {
//                        meets.add(newMeet);
//                        System.out.println("OK");
//                    }
//                }
//            }
//            if (input.contains("PRINT")) {
//                String[] inf = input.replaceAll("PRINT ", "").split(" ");
//                int day = Integer.parseInt(inf[0]);
//                Collections.sort(meets);
//                meets.forEach(meet -> meet.print(day, inf[1]));
//            }
//            count++;
//        }
//    }
//
//    private static class Meet implements Comparable<Meet> {
//        private int day;
//        private String time;
//        private int during;
//        private int n;
//        private List<String> people;
//        private int start;
//        private int end;
//        private static String space = "";
//
//        public Meet(String input) {
//            String[] infOfMeeting = input.split(" ");
//            day = Integer.parseInt(infOfMeeting[0]);
//            time = infOfMeeting[1];
//            during = Integer.parseInt(infOfMeeting[2]);
//            n = Integer.parseInt(infOfMeeting[3]);
//            people = new ArrayList<>();
//            for (int i = 4; i < infOfMeeting.length; i++) {
//                this.people.add(infOfMeeting[i]);
//            }
//            start = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
//            end = start + during;
//        }
//
//        public void print(int day, String name) {
//            if (this.day == day && people.contains(name)) {
//                String inf = time + " " + during;
//                for (String man : people) {
//                    inf += " " + man;
//                }
//                System.out.println(inf);
//            }
//        }
//
//        public void appoint(int day, int start, int end, String name) {
//            if (this.day == day && !(this.start >= end || this.end <= start) && people.contains(name)) {
//                System.out.print(space + name);
//                if (space.isEmpty()) {
//                    space = " ";
//                }
//            }
//        }
//
//        public boolean crossCheck(int day, int start, int end) {
//            if (this.day == day && !(this.start >= end || this.end <= start)) {
//                return true;
//            }
//            return false;
//        }
//
//        public int getDay() {
//            return day;
//        }
//
//        public String getTime() {
//            return time;
//        }
//
//        public int getDuring() {
//            return during;
//        }
//
//        public int getN() {
//            return n;
//        }
//
//        public List<String> getPeople() {
//            return people;
//        }
//
//        public int getStart() {
//            return start;
//        }
//
//        public int getEnd() {
//            return end;
//        }
//
//        @Override
//        public int compareTo(Meet o) {
//            int flag = this.day - o.day;
//            if (flag == 0){
//                flag = this.start - o.start;
//            }
//            return flag;
//        }
//    }
//
//}
