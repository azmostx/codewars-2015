import java.util.ArrayList;
import java.util.Scanner;

public class prob13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        number = number.substring(0, number.length() - 1);
        String[] array = new String[scanner.nextInt()];
        int index = 0;
        for (int i = 0; i < number.length(); i++) {
            int j = i + 1;
            int maxJ = i + 1;
            for (; j <= number.length() && j - i < 7; j++) {
                if (isAlternating(Integer.toBinaryString(Integer.parseInt(number.substring(i, j))))) maxJ = j;
            }
            array[index] = number.substring(i, maxJ);
            i = maxJ - 1;
            index++;
        }
        for (String s : array) {
            System.out.println(s);
        }
    }

    private static boolean isAlternating(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return false;
        }
        return true;
    }
}
