import java.util.*;

public class prob14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int l = scanner.nextInt();
        int minNeeded = l * w;
        ArrayList<Integer> minNeededList = new ArrayList<>();
        char[][] minMatrix = new char[l][w];
        TreeSet<Pair> ts = new TreeSet<>();
        for (int i = Math.min(l, w); i >= 1 ; i--) {
            char[][] matrix = new char[l][w];
            tsReload(l, w, ts);
            int needed = 1;
            ArrayList<Integer> neededList = new ArrayList<>();
            neededList.add(i);
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
                    ts.remove(new Pair(j, k));
                    matrix[j][k] = 'a';
                }
            }
            char c = 'b';
            while (!ts.isEmpty()) {
                Pair pair = ts.first();
                neededList.add(fillUpToMax(matrix, pair.i, pair.j, ts, c));
                c++;
                needed++;
            }
            if (needed < minNeeded) {
                minMatrix = matrix;
                minNeeded = needed;
                minNeededList = neededList;
            }
        }
        Collections.sort(minNeededList);
        System.out.printf("%d squares can cover %dx%d.%n", minNeeded, w, l);
        for (Integer integer : minNeededList) System.out.print(integer + " ");
        System.out.println();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(minMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void tsReload(int l, int w, TreeSet<Pair> ts) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                ts.add(new Pair(i, j));
            }
        }
    }

    private static int fillUpToMax(char[][] matrix, int i, int j, TreeSet<Pair> ts, char c) {
        int upperBoundI = 0;
        int upperBoundJ = 0;
        while (ts.contains(new Pair(upperBoundI + i, j))) upperBoundI++;
        while (ts.contains(new Pair(i, upperBoundJ + j))) upperBoundJ++;
        int upperBound = Math.min(upperBoundI, upperBoundJ);
        for (int k = i; k < i + upperBound; k++) {
            for (int l = j; l < j + upperBound; l++) {
                ts.remove(new Pair(k, l));
                matrix[k][l] = c;
            }
        }
        return upperBound;
    }

    static class Pair implements Comparable{
        private final int i;
        private final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            Pair other = (Pair) o;
            int comparison = Integer.compare(this.i * this.j, other.i * other.j);
            if (comparison == 0) comparison = Integer.compare(this.i + this.j, other.i + other.j);
            if (comparison == 0) comparison = Integer.compare(this.i, other.i);
            return comparison;
        }
    }
}
