package mars.rover;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MarsRover {

    private static final int END_OF_PROGRAM = -1;

    public static String move(int x, int y, char direction, String instructions) throws IOException {
        return move(x, y, direction, new StringReader(instructions));
    }

    public static String move(int x, int y, char direction, Reader instructions) throws IOException {
        final int instruction = instructions.read();

        if (instruction != END_OF_PROGRAM) {
            if (instruction == 'L') {
                if (direction == 'N') {
                    return move(x, y, 'W', instructions);
                } else if (direction == 'W') {
                    return move(x, y, 'S', instructions);
                } else if (direction == 'S') {
                    return move(x, y, 'E', instructions);
                } else if (direction == 'E') {
                    return move(x, y, 'N', instructions);
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    return move(x, y, 'E', instructions);
                } else if (direction == 'W') {
                    return move(x, y, 'N', instructions);
                } else if (direction == 'S') {
                    return move(x, y, 'W', instructions);
                } else if (direction == 'E') {
                    return move(x, y, 'S', instructions);
                }
            } else if (instruction == 'M') {
                if (direction == 'N') {
                    return move(x, y + 1, 'N', instructions);
                } else if (direction == 'S') {
                    return move(x, y - 1, 'S', instructions);
                } else if (direction == 'W') {
                    return move(x - 1, y, 'W', instructions);
                } else if (direction == 'E') {
                    return move(x + 1, y, 'E', instructions);
                }
            }
        }
        return x + " " + y + " " + direction;
    }
}
