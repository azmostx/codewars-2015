import java.util.Scanner;

public class prob10 {
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Scanner scanner1 = new Scanner(scanner.nextLine());
            int n1 = scanner1.nextInt();
            for (int j = 0; j < n1; j++) {
                System.out.print((char)toAscii(scanner1.next()));
            }
            System.out.println();
        }
    }
    private static int toAscii(String code) {
        if (code.equals("40")) return ' ';
        if (code.equals("4B")) return '.';
        if (code.equals("6B")) return ',';
        if (code.equals("5A")) return '!';
        char a, b;
        if (Character.isLetter(code.charAt(0))) {
            a = (char) (code.charAt(0) - 15);
        } else {
            a = (char) (code.charAt(0) - 8);
        }
        b = (char) (code.charAt(1) - 1);
        int result = Integer.parseInt("" + a + b, 9);
        if (result > 17) result--;
        if (result > 52) result--;
        return result > 25 ? result + 30 : result + 97;
    }
}
