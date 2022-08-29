import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class prob16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Transition> transitions = new HashMap<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            char state = scanner.next().charAt(0);
            char trigger = scanner.next().charAt(0);
            char target = scanner.next().charAt(0);
            if (!transitions.containsKey(state)) transitions.put(state, new Transition());
            transitions.get(state).triggers.add(trigger);
            transitions.get(state).targets.add(target);
        }

        String encoded = scanner.next();
        StringBuilder decoded = new StringBuilder();

        char condition = '#';
        for (char next : encoded.toCharArray()) {
            condition = transitions.get(condition).findTarget(next);
            decoded.append(condition);
        }
        System.out.println(decoded);
    }
    static private class Transition {
        public Transition() {
            triggers = new ArrayList<>();
            targets = new ArrayList<>();
        }
        List<Character> triggers;
        List<Character> targets;
        private char findTarget(char trigger) {
            for (int i = 0; i < triggers.size(); i++) if (trigger == triggers.get(i)) return targets.get(i);
            return ' ';
        }
    }
}
