import java.util.Scanner;

public class YandexN1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputN = scanner.nextLine();
        int nOfServers = Integer.parseInt(inputN);
        String[] inputs = new String[nOfServers];
        double sum = 0;
        for (int i = 0; i < nOfServers; i++) {
            inputs[i] = scanner.nextLine();
            sum += p(inputs[i]);
        }
        for (String input : inputs) {
            System.out.println(p(input)/sum);
        }

    }

    public static double p(String input) {
        int gap = input.indexOf(" ");
        double a = Integer.parseInt(input.substring(0, gap));
        double b = Integer.parseInt(input.substring(gap + 1));
        return a * b / 100;
    }
}
