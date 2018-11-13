import java.util.*;

public class YandexN6 {
    public static List<Dude> coworkers = new ArrayList<>();
    private static long result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputA = scanner.nextLine().split(" ");
        String[] inputB = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(inputA[i]);
            int b = Integer.parseInt(inputB[i]);
            coworkers.add(new Dude(a, b));
        }

        int m = Integer.parseInt(scanner.nextLine());
        String inputM[];
        for (int i = 0; i < m; i++) {
            inputM = scanner.nextLine().split(" ");
            int num = Integer.parseInt(inputM[0]);
            int type = Integer.parseInt(inputM[1]);
            int d = Integer.parseInt(inputM[2]);
            if (type == 1) {
                coworkers.get(num - 1).addA(d);
            } else {
                coworkers.get(num - 1).addB(d);
            }
        getResult();
    }
        scanner.close();
    }

    public static void getResult() {
        coworkers.stream().sorted((x, y) -> y.getK() - x.getK()).limit(coworkers.size() / 2).forEach(e -> result += e.getA());
        coworkers.stream().sorted(Comparator.comparingInt(Dude::getK)).limit(coworkers.size() / 2).forEach(e -> result += e.getB());
        System.out.println(result);
        result = 0;
    }

    private static class Dude {
        private int a;
        private int b;
        private int k;

        public Dude(int a, int b) {
            this.a = a;
            this.b = b;
            this.k = a - b;
        }

        public int getA() {
            return a;
        }

        public void addA(int d) {
            a += d;
            k = a - b;
        }

        public int getB() {
            return b;
        }


        public void addB(int d) {
            b += d;
            k = a - b;
        }

        public int getK() {
            return k;
        }
    }
}
