package mars.rover;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MarsRover {

    private static final int END_OF_PROGRAM = -1;

    public static String move(int x, int y, char direction, String instructions) throws IOException {
        return move(new Coordinates(x, y), direction, new StringReader(instructions));
    }

    public static String move(Coordinates coordinates, char direction, Reader instructions) throws IOException {
        final int instruction = instructions.read();

        if (instruction != END_OF_PROGRAM) {
            if (instruction == 'L') {
                if (direction == 'N') {
                    return move(coordinates, 'W', instructions);
                } else if (direction == 'W') {
                    return move(coordinates, 'S', instructions);
                } else if (direction == 'S') {
                    return move(coordinates, 'E', instructions);
                } else if (direction == 'E') {
                    return move(coordinates, 'N', instructions);
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    return move(coordinates, 'E', instructions);
                } else if (direction == 'W') {
                    return move(coordinates, 'N', instructions);
                } else if (direction == 'S') {
                    return move(coordinates, 'W', instructions);
                } else if (direction == 'E') {
                    return move(coordinates, 'S', instructions);
                }
            } else if (instruction == 'M') {
                if (direction == 'N') {
                    return move(new Coordinates(coordinates.x(), coordinates.y() + 1), 'N', instructions);
                } else if (direction == 'S') {
                    return move(new Coordinates(coordinates.x(), coordinates.y() - 1), 'S', instructions);
                } else if (direction == 'W') {
                    return move(new Coordinates(coordinates.x() - 1, coordinates.y()), 'W', instructions);
                } else if (direction == 'E') {
                    return move(new Coordinates(coordinates.x() + 1, coordinates.y()), 'E', instructions);
                }
            }
        }
        return coordinates.x() + " " + coordinates.y() + " " + direction;
    }
}
