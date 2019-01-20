package mars.rover;

public enum Direction {
    EAST {
        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Coordinates move(Coordinates start) {
            return new Coordinates(start.x() + 1, start.y());
        }

        @Override
        public String toString() {
            return "E";
        }
    },
    SOUTH {
        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Coordinates move(Coordinates start) {
            return new Coordinates(start.x(), start.y() - 1);
        }

        @Override
        public String toString() {
            return "S";
        }
    },
    WEST {
        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Coordinates move(Coordinates start) {
            return new Coordinates(start.x() - 1, start.y());
        }

        @Override
        public String toString() {
            return "W";
        }
    },
    NORTH {
        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Coordinates move(Coordinates start) {
            return new Coordinates(start.x(), start.y() + 1);
        }

        @Override
        public String toString() {
            return "N";
        }
    };

    public abstract Direction left();

    public abstract Direction right();

    public abstract Coordinates move(Coordinates start);

    public static Direction parse(char direction) {
        switch (direction) {
            case 'E':
                return EAST;
            case 'S':
                return SOUTH;
            case 'W':
                return WEST;
            case 'N':
                return NORTH;
            default:
                throw new IllegalArgumentException("Unknown direction " + direction);
        }
    }
}
