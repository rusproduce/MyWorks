import java.util.Scanner;

public class YandexN5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        long k = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);
        long d = Integer.parseInt(input[2]);
        long booksRead = 1;
        long goodDays = 0;
        if (d < 6) {
            m += k;
        }
        while (booksRead <= m) {
            goodDays++;
            m -= booksRead;
            booksRead++;
            d = d % 7 + 1;
            m = (d < 6) ? m + k : m;
        }
        System.out.println(goodDays);
    }
}
