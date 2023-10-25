public class Floor
{
    Room head, tail, current, mapTemp;
    String[] map = new String[10];

    /**
     * Creates a floor with 10 rooms
     * @param player1   the player
     */
    public Floor(Hero player1)
    {
        for (int i = 0; i < 10; i++)
        {
            Room newRoom = new Room(player1);

            if (i == 0)
                head = newRoom;
            else
            {
                newRoom.previous = tail;
                tail.next = newRoom;
            }
            tail = newRoom;
        }

        if (head != null)                               // this is to make the floor circular
        {
            tail.next = head;
            head.previous = tail;
        }
    }

    /**
     * Moves the player forward one room
     * @param player1   the player
     */
    public void moveForward(Hero player1)
    {
        if (current == null)
            current = head;
        current.printRoomInfo();
        roomAction(player1, current);
        current = current.next;
    }

    /**
     * Moves the player backward one room
     * @param player1   the player
     */
    public void moveBackward(Hero player1)
    {
        if (current == null)
            current = tail;
        current.printRoomInfo();
        roomAction(player1, current);
        current = current.previous;
    }

    /**
     * Spawns a monster, trap, or loot depending on the room
     * @param player1   the player
     * @param current   the current room the player is in
     */
    private void roomAction(Hero player1, Room current)
    {
        if (current.roomContents.getDescription().equals("Monster"))            // if it is a monster room, spawn a spider and battle it
        {
            Spider spider = new Spider(player1);
            player1.battle(spider);
        }
        else if (current.roomContents.getDescription().equals("Trap"))          // if it is a trap room, spawn a trap and trigger it
        {
            Trap trap = new Trap();
            trap.trapEvent(player1);
        }
        else if (current.roomContents.getDescription().equals("Loot"))          // if it is a loot room, spawn a loot and trigger it
        {
            Loot loot = new Loot();
            loot.lootEvent(player1);
        }
    }

    /**
     * Prints the map of the floor, showing the contents of each room
     */
    public void printMap()
    {
        System.out.println();
        mapTemp = head;
        for (int i = 0; i < 10; i++)
        {
            map[i] = mapTemp.roomContents.getDescription();
            mapTemp = mapTemp.next;
            System.out.println(map[i]);
        }
        System.out.println();
    }
}