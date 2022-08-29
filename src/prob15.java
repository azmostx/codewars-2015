import java.util.Scanner;

public class prob15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n + 1; i++) {
            String acro = scanner.next().toUpperCase();
            String line = scanner.nextLine().substring(1);
            String[] words = line.toUpperCase().split("[\\-\\W+]");
            int result = compute(acro, words, 0, false, true, 0);
            String type = switch (result) {
                case 0 -> "NOT an";
                case 1 -> "a PARTIAL COMPLEX";
                case 2 -> "a PARTIAL SIMPLE";
                case 3 -> "a COMPLETE COMPLEX";
                case 4 -> "a COMPLETE SIMPLE";
                default -> "";
            };
            System.out.printf("%s is %s acronym for %s%n", acro, type, line);
        }
    }
    private static int compute(String acro, String[] words, int wIndex, boolean complex, boolean complete, int aIndex) {
        if (aIndex == acro.length()) {
            if (wIndex != words.length) complete = false;
            if (complete) {
                if (!complex) return 4;
                else return 3;
            } else {
                if (!complex) return 2;
                else return 1;
            }
        } if (wIndex == words.length) return 0;
        if (words[wIndex].charAt(0) == acro.charAt(aIndex)) {
            if (words[wIndex].length() > 1 && aIndex + 1 < acro.length() && words[wIndex].charAt(1) == acro.charAt(aIndex + 1)) {
                return Math.max(
                        compute(acro, words, wIndex + 1, true, complete, aIndex + 2),
                        compute(acro, words, wIndex + 1, complex, complete, aIndex + 1)
                );
            }
            else return compute(acro, words, wIndex + 1, complex, complete, aIndex + 1);
        }
        return compute(acro, words, wIndex + 1, complex, false, aIndex);
    }
}

