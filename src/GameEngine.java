import java.util.Scanner;

/**
 * The game engine that runs the game
 */
public class GameEngine
{
    private static int roomsCleared = 0;

    /**
     * Runs the game
     */
    public void runGame()
    {
        Hero player1 = new Hero();
        Scanner in = new Scanner(System.in);
        final int roomsNeeded = 10;
        int selection;

        while (player1.getCurrentHP() > 0)                              // create a new floor, and keep creating new floors until the player dies
        {
            Floor dungeonFloor = new Floor(player1);

            roomsCleared = 0;
            while (roomsCleared < roomsNeeded)                          // keep them in the floor until they clear 10 rooms
            {
                printOptions();
                selection = in.nextInt();
                performOption(selection, dungeonFloor, player1);
            }
            System.out.println("Floor cleared! Descending to next floor...\n");
        }
    }

    /**
     * Prints the options the player can choose from
     */
    public void printOptions()
    {
        System.out.print("""
                1. Walk forward
                2. Walk backward
                3. View stats
                4. View map
                0. Quit
                Selection >\s""");
    }

    /**
     * Performs the action the player selected
     * @param selection     the action the player input
     * @param dungeonFloor  the floor the player is on
     * @param player1       the player
     */
    public static void performOption(int selection, Floor dungeonFloor, Hero player1)
    {
        if (selection == 1)
        {
            dungeonFloor.moveForward(player1);
            if (!dungeonFloor.current.isCleared())                      // increment roomsCleared if the room hasn't been cleared yet
                roomsCleared++;
        }
        else if (selection == 2)
        {
            dungeonFloor.moveBackward(player1);
            if (!dungeonFloor.current.isCleared())
                roomsCleared++;
        }
        else if (selection == 3)
        {
            System.out.println();
            player1.printStats();
            System.out.println();
        }
        else if (selection == 4)
            dungeonFloor.printMap();
        else if (selection == 0)
            System.exit(0);
    }
}