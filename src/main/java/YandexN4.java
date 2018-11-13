
import java.util.*;
import java.util.stream.Collectors;

public class YandexN4 {
    private static List<Dude> coworkers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String[] input = scanner.nextLine().split(" ");
        int n = 3;
//                Integer.parseInt(input[0]);
        int m = 1;
//                Integer.parseInt(input[1]);
        for (int i = 1; i <= n; i++) {
            Dude dude = new Dude(i);
            coworkers.add(dude);
        }
        int count = 0;

        while (count < m) {
//            input = scanner.nextLine().split(" ");
            int a = 1;
//                    Integer.parseInt(input[0]);
            int b = 2;
//                    Integer.parseInt(input[1]);
            coworkers.get(a - 1).makefriends(b);
            coworkers.get(a - 1).makefriends(b + 1);
            coworkers.get(a).makefriends(b + 1);
            count++;
        }

        List<Dude> komanda1 = new ArrayList<>();
        List<Dude> komanda2 = new ArrayList<>();
        Set<Integer> commonFriends = new HashSet<Integer>();
        komanda1.add(coworkers.get(0));
        commonFriends.addAll(komanda1.get(0).getFriendsId());
        while (!commonFriends.isEmpty()) {

        }
        komanda2.addAll(coworkers);
        komanda2.removeAll(komanda1);
        if (allFriends(komanda2)) {
            success(komanda2);
        } else {
            fail();
        }
    }


    public static void fail() {
        System.out.println(-1);
    }

    public static void success(List<Dude> list) {
        System.out.println(list.size());
        System.out.println(list.stream().map(e -> e.getId().toString()).collect(Collectors.joining(" ")));
        System.out.println(coworkers.stream().filter(e -> !list.contains(e)).map(e -> e.getId().toString()).collect(Collectors.joining(" ")));
    }

    public static boolean allFriends(List<Dude> list) {
        List<Integer> idList = new ArrayList<>();
        list.forEach(dude -> idList.add(dude.getId()));
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            idList.remove(0);
            if (list.get(i).getFriendsId().containsAll(idList)) {
                count++;
            }
        }
        return count == list.size() - 1;
    }

    public static void print() {
        for (Dude dude : coworkers) {
            System.out.println(dude.toString());
        }
    }

    private static class Dude {
        private Integer id;
        private Set<Integer> friendsId;

        public Dude(int id) {
            this.id = id;
            friendsId = new HashSet<>();
        }

        public void makefriends(int i) {
            friendsId.add(i);
            coworkers.get(i - 1).getFriendsId().add(id);
        }

        public Integer getId() {
            return id;
        }

        public Set<Integer> getFriendsId() {
            return friendsId;
        }

        @Override
        public String toString() {
            return id + " " + friendsId;
        }
    }
}
