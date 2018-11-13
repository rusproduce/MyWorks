import java.util.Scanner;

public class SQRT {
    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        double input;
        while(true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0){
                    System.out.println("Число не может быть отрицательным! Попробуйте ещё раз");
                }else {
                    System.out.println(sqrt(input));
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Вы ввели не коррекное число, попробуйте ещё раз");
            }
        }
    }

    public static double sqrt(double x) {
        double a = 0;
        double y = 1;
        double accuracy = 0.000000001;
        for (int i = 1; i <= x / y; i++) {
            a += y;
            if (a * a - x > 0) {
                a = a - y;
                if (x - a * a < accuracy){
                    break;
                }
                y = y / 10;
            }
        }
        return a;
    }
}
