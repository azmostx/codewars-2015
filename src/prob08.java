import java.util.Scanner;

public class prob08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int na = 0;
        int duplicates = 0;
        int empty = 0;
        String[] cubes = new String[300];
        boolean[] dups = new boolean[300];
        for (int i = 0; i < a; i++) {
            String name = scanner.next();
            int t = scanner.nextInt();
            if (t == 0) na++;
            else if (cubes[t - 1] != null && !dups[t - 1]) {
                duplicates++;
                dups[t - 1] = true;
            }
            else if (name.equals("NA")) empty++;
            else cubes[t - 1] = name;
        }
        System.out.printf("Empty Cubes: %d%nDuplicate Cube Assignments: %d%nEmployees without Cube: %d%n", empty, duplicates, na);
    }
}
