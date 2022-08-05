import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class IsPathCrossing {
    class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isPathCrossing(String path) {
        Position p = new Position(0, 0);
        Set<Position> posTracker = new HashSet<>();
        posTracker.add(p);

        int prevX = p.x;
        int prevY = p.y;
        for (int i = 0; i < path.length(); i++) {
            int cur = path.charAt(i);

            Position newPosition = new Position(prevX,prevY);
            switch (cur) {

                case 'N':
                    newPosition.y ++;
                    if(posTracker.contains(newPosition)) return true;
                    posTracker.add(newPosition);
                    break;

                case 'S':
                    newPosition.y --;
                    if(posTracker.contains(newPosition)) return true;
                    posTracker.add(newPosition);
                    break;

                case 'E':
                    newPosition.x ++;
                    if(posTracker.contains(newPosition)) return true;
                    posTracker.add(newPosition);
                    break;

                case 'W':
                    newPosition.x--;
                    if(posTracker.contains(newPosition)) return true;
                    posTracker.add(newPosition);
                    break;
            }
            prevX = newPosition.x;
            prevY = newPosition.y;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsPathCrossing().isPathCrossing("NESWW"));
    }

}