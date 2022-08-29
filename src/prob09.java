import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class prob09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Team> pq = new PriorityQueue<>(Team.COMPARATOR);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0) break;
            pq.add(new Team(a, b));
        }
        for (int i = 1; i <= 5 && !pq.isEmpty(); i++) {
            Team t = pq.poll();
            System.out.printf("%d %d %d%n", i, t.id, t.score);
        }
    }
    static class Team {
        int id;
        int score;

        public Team(int id, int score) {
            this.id = id;
            this.score = score;
        }

        final static Comparator<Team> COMPARATOR = (team, t1) -> Integer.compare(t1.score, team.score);
    }
}
