import java.util.Scanner;

public class prob11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int w = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            if (w == 0) break;
            String[] diamond = renderDiamond(w);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < c; k++) {
                        System.out.print(diamond[j]);
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    public static String[] renderDiamond(int width) {
        String[] strings = new String[width];
        int index = 0;
        for (int i = 1; i <= width / 2; i++) {
            String row = "";
            row += "#".repeat(width / 2 - i);
            row += "/".repeat(i);
            row += "\\".repeat(i);
            row += "#".repeat(width / 2 - i);
            strings[index++] = row;
        }
        for (int i = width / 2; i >= 1; i--) {
            String row = "";
            row += "#".repeat(width / 2 - i);
            row += "\\".repeat(i);
            row += "/".repeat(i);
            row += "#".repeat(width / 2 - i);
            strings[index++] = row;
        }
        return strings;
    }
}
