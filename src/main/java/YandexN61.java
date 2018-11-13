import java.util.*;

public class YandexN61 {
    public static List<Dude> coworkers = new ArrayList<>();
    private static int result;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = 6;
////                Integer.parseInt(scanner.nextLine());
//        String[] inputA = {"4", "5", "10", "20", "18", "0"};
////                scanner.nextLine().split(" ");
//        String[] inputB = {"2", "1", "4", "6", "9", "5"};
////                scanner.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            int a = Integer.parseInt(inputA[i]);
//            int b = Integer.parseInt(inputB[i]);
//            coworkers.add(new Dude(a, b));
//        }


    }

    public void getResult(){
        if (coworkers.stream().filter(e -> e.getK() >= 0).count() >= coworkers.size() / 2) {
            coworkers.stream().sorted((x, y) -> y.getK() - x.getK()).limit(coworkers.size() / 2).forEach(e -> result += e.getA()); // как делать два действия в лямде e.setType(1)
            coworkers.stream().sorted(Comparator.comparingInt(Dude::getK)).limit(coworkers.size() / 2).forEach(e -> result += e.getB());
//            coworkers.sort((x, y) -> y.getK() - x.getK());
//            for (int i = 0; i < n / 2; i++) {
//                result += coworkers.get(i).getA();
//                coworkers.get(i).setType(1);
//            }
        } else {
            coworkers.stream().sorted(Comparator.comparingInt(Dude::getK)).limit(coworkers.size() / 2).forEach(e -> result += e.getB());
        }
        System.out.println(result);
    }

    private static class Dude {
        private int a;
        private int b;
        private int k;
        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Dude(int a, int b) {
            this.a = a;
            this.b = b;
            this.k = a - b;
        }

        public int getA() {
            return a;
        }

        public void setA(int d) {
            this.a += d;
            this.k = a - b;
        }

        public int getB() {
            return b;
        }

        public void setB(int d) {
            this.b += d;
            this.k = a - b;
        }

        public int getK() {
            return k;
        }

        @Override
        public String toString() {
            return "{" +
                    "a=" + a +
                    ", b=" + b +
                    ", k=" + k +
                    ", type=" + type +
                    '}';
        }
    }
}
