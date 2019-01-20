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

        if (instruction != END_OF_PROGRAM) {
            if (instruction == 'L') {
                return move(coordinates, direction.left(), instructions);
            } else if (instruction == 'R') {
                return move(coordinates, direction.right(), instructions);
            } else if (instruction == 'M') {
                return move(direction.move(coordinates), direction, instructions);
            }
        }

        return coordinates.x() + " " + coordinates.y() + " " + direction;
    }
}
