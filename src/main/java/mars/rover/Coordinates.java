package mars.rover;

import java.util.Objects;

public final class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates)) {
            return false;
        }

        final Coordinates other = (Coordinates) o;

        return x == other.x && y == other.y;
    }
}
