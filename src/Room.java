import java.util.Random;

/**
 * A room in the dungeon
 */
public class Room
{
    public Entity roomContents;
    Room next, previous;

    /**
     * Creates a room with a random entity in it
     * @param player1   the player
     */
    public Room(Hero player1)
    {
        Random rand = new Random();
        int roomType = rand.nextInt(101);

        if (roomType < 70)                                  // Favors spider rooms
            roomContents = new Spider(player1);
        else if (roomType < 85)
            roomContents = new Trap();
        else
            roomContents = new Loot();
    }

    /**
     * Prints what's in the room when the player enters it
     */
    public void printRoomInfo()
    {
        System.out.println("\nYou enter a " + roomContents.getDescription() + " room.\n");
    }

    /**
     * Checks if the room is cleared
     * @return  if the room is clear (t/f)
     */
    public boolean isCleared()
    {
        return roomContents.getDescription().equals("Spider") || roomContents.getDescription().equals("Trap") || roomContents.getDescription().equals("Loot");
    }
}