import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class prob17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            char dir = scanner.next().charAt(0);

            char c = '0';
            char maxC = scanner.next().charAt(0);
            if (dir == '#') break;

            int maxI = 1;
            int i = 0;

            PointAndDraw pad = new PointAndDraw();
            while (true) {
                pad.draw(c);
                if (c == maxC) break;
                if (dir == '\\') {
                    pad.moveRight();
                    pad.moveDown();
                    pad.draw('\\');
                    pad.moveRight();
                    pad.moveDown();
                }
                if (dir == '/') {
                    pad.moveRight();
                    pad.moveUp();
                    pad.draw('/');
                    pad.moveRight();
                    pad.moveUp();
                }
                if (dir == '-') {
                    pad.moveLeft();
                    pad.draw('-');
                    pad.moveLeft();
                    pad.draw('-');
                    pad.moveLeft();
                    pad.draw('-');
                    pad.moveLeft();
                }
                i++;
                if (i == maxI) {
                    if (dir == '\\') dir = '-';
                    else if (dir == '-') dir = '/';
                    else dir = '\\';
                    i = 0;
                    maxI++;
                }
                if (c == '9') c = 'A';
                else c++;
            }
            System.out.print(pad.render());
        }
    }
    static private class PointAndDraw {
        private int length;
        private int width;
        private int i;
        private int j;
        private List<StringBuilder> builderList;

        private PointAndDraw() {
            this.length = 1;
            this.width = 1;
            this.i = 0;
            this.j = 0;
            this.builderList = new ArrayList<>();
            this.builderList.add(new StringBuilder("."));
        }

        public void moveLeft() {
            if (j == 0) {
                for (int k = 0; k < length; k++) builderList.get(k).insert(0, ".");
                width++;
            } else j--;
        }
        public void moveRight() {
            if (j == width - 1) {
                for (int k = 0; k < length; k++) builderList.get(k).append(".");
                width++;
            } j++;
        }
        public void moveUp() {
            if (i == 0) {
                builderList.add(0, new StringBuilder(".".repeat(width)));
                length++;
            } else i--;
        }
        public void moveDown() {
            if (i == length - 1) {
                builderList.add(new StringBuilder(".".repeat(width)));
                length++;
            } i++;
        }

        public void draw(char c) {
            builderList.get(i).replace(j,j+1,"" + c);
        }

        public String render() {
            StringBuilder render = new StringBuilder();
            for (StringBuilder sb: builderList) {
                render.append(sb.toString()).append("\n");
            }
            return render.toString();
        }
    }
}
