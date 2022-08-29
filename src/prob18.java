import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class prob18 {
    private static ArrayList<int[]> moves;
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        int startI = 0, startJ = 0, endI = 0, endJ = 0;
        int[][] matrix = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                char temp = scanner.next().charAt(0);
                if (temp == 'S') {
                    startI = i;
                    startJ = j;
                    matrix[i][j] = 9;
                }
                else if (temp == 'X') {
                    endI = i;
                    endJ = j;
                    matrix[i][j] = -1;
                } else matrix[i][j] = temp - 48;
            }
        }

        char[][] outputMatrix = new char[length][width];
        for (char[] chars : outputMatrix) {
            Arrays.fill(chars, '#');
        }
        moves = new ArrayList<>();
        compute(startI, startJ, matrix, new ArrayList<>());
        for (int[] move : moves) {
            outputMatrix[move[0]][move[1]] = '.';
        }
        outputMatrix[startI][startJ] = 'S';
        outputMatrix[endI][endJ] = 'X';
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void compute(int i, int j, int[][] matrix, ArrayList<int[]> tempMoves) {
        if (!moves.isEmpty()) return;
        if (matrix[i][j] == -1) {
            moves = new ArrayList<>(tempMoves);
            return;
        }
        int temp = matrix[i][j];
        if (i > 0 && matrix[i-1][j] <= matrix[i][j]) {
            tempMoves.add(new int[]{i-1, j});
            matrix[i][j] = 10;
            compute(i - 1, j, matrix, tempMoves);
            matrix[i][j] = temp;
            tempMoves.remove(tempMoves.size() - 1);
        }
        if (i + 1 < matrix.length && matrix[i+1][j] <= matrix[i][j]) {
            tempMoves.add(new int[]{i+1, j});
            matrix[i][j] = 10;
            compute(i + 1, j, matrix, tempMoves);
            matrix[i][j] = temp;
            tempMoves.remove(tempMoves.size() - 1);
        }
        if (j > 0 && matrix[i][j-1] <= matrix[i][j]) {
            tempMoves.add(new int[]{i, j-1});
            matrix[i][j] = 10;
            compute(i, j-1, matrix, tempMoves);
            matrix[i][j] = temp;
            tempMoves.remove(tempMoves.size() - 1);
        }
        if (j + 1 < matrix[i].length && matrix[i][j+1] <= matrix[i][j]) {
            tempMoves.add(new int[]{i, j+1});
            matrix[i][j] = 10;
            compute(i, j+1, matrix, tempMoves);
            matrix[i][j] = temp;
            tempMoves.remove(tempMoves.size() - 1);
        }
        matrix[i][j] = 10;
    }
}
