import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm here.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        Maze maze = new Maze(22, 22);

        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        maze.startAtZero();
        maze.endAtTopRight();

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        int step = 0;
        while (step < 10000 && !maze.isFinished()) {
            System.out.println(maze);
            try {
                Thread.sleep(200);
            } catch (Exception e) { }
            maze.turnRight();
            if (maze.canMove()) {
                maze.move();
            } else {
                maze.turnLeft();
                if (maze.canMove()) {
                    maze.move();
                } else {
                    maze.turnLeft();
                    maze.move();
                }
            }
            step++;
        }

        if (maze.isFinished()) {
            System.out.println("You solved the maze in " + step + " steps");
        } else {
            System.out.println("Try again!");
        }
    }
}
