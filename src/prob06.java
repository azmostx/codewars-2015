import java.util.Scanner;

public class prob06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println((int)Math.ceil(a * b * c / 27.0));
    }
}
