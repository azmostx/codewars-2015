import java.util.Scanner;

public class prob12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] grid = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextDouble();
            }
        }
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && calculate(grid[i][j] - grid[i - 1][j], false) > max)
                    max = calculate(grid[i][j] - grid[i - 1][j], false);

                if (i > 0 && j > 0 && calculate(grid[i][j] - grid[i - 1][j - 1], true) > max)
                    max = calculate(grid[i][j] - grid[i - 1][j - 1], true);

                if (j > 0 && calculate(grid[i][j] - grid[i][j - 1], false) > max)
                    max = calculate(grid[i][j] - grid[i][j - 1], false);

                if (j > 0 && i < n - 1 && calculate(grid[i][j] - grid[i + 1][j - 1], true) > max)
                    max = calculate(grid[i][j] - grid[i + 1][j - 1], true);

                if (i < n - 1 && calculate(grid[i][j] - grid[i + 1][j], false) > max)
                    max = calculate(grid[i][j] - grid[i + 1][j], false);

                if (i < n - 1 && j < n - 1 && calculate(grid[i][j] - grid[i + 1][j + 1], true) > max)
                    max = calculate(grid[i][j] - grid[i + 1][j + 1], true);

                if (j < n - 1 && calculate(grid[i][j] - grid[i][j + 1], false) > max)
                    max = calculate(grid[i][j] - grid[i][j + 1], false);

                if (j < n - 1 && i > 0 && calculate(grid[i][j] - grid[i - 1][j + 1], true) > max)
                    max = calculate(grid[i][j] - grid[i - 1][j + 1], true);
            }
        }
        System.out.printf("Max angle is %.2f degrees%n", Math.toDegrees(max));
    }

    public static double calculate(double a, boolean diagonal) {
        return Math.asin(Math.abs(a) / Math.sqrt((diagonal ? 2 : 1) + Math.abs(a) * Math.abs(a)));
    }
}
