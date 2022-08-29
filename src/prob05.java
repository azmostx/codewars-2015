import java.util.Scanner;

public class prob05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.printf("%d x (%d + %d) = %d x %d + %d x %d%n", a, b,c, a, b, a,c);
        System.out.printf("%d x %d = %d + %d%n", a, b + c, a * b, a * c);
        System.out.printf("%d = %d%n", a * b + a * c, a * b + a * c);
    }
}
