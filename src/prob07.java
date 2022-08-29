import java.util.Scanner;

public class prob07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double d = scanner.nextDouble();
            if (d == 0) break;
            System.out.println(Math.cbrt(d * d));
        }
    }
}
