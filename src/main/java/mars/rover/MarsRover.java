package mars.rover;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MarsRover {

    private static final int END_OF_PROGRAM = -1;

    public static String move(int x, int y, char direction, String instructions) throws IOException {
        return move(new Coordinates(x, y), Direction.parse(direction), new StringReader(instructions));
    }

    public static String move(Coordinates coordinates, Direction direction, Reader instructions) throws IOException {
        final int instruction = instructions.read();

        switch (instruction) {
            case 'L':
                return move(coordinates, direction.left(), instructions);
            case 'R':
                return move(coordinates, direction.right(), instructions);
            case 'M':
                return move(direction.move(coordinates), direction, instructions);
            case END_OF_PROGRAM:
                return coordinates.x() + " " + coordinates.y() + " " + direction;
            default:
                throw new IllegalArgumentException("Unknown instruction " + instruction);
        }
    }
}