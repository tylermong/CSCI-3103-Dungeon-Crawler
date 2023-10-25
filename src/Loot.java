import java.util.Random;

/**
 * Loot room that buffs player stats
 */
public class Loot extends Entity
{
    public Loot()
    {
        super("Loot");
    }

    /**
     * Buffs the player's stats
     * @param player1   the player
     */
    public void lootEvent(Hero player1)
    {
        Random rand = new Random();
        int rngValue = rand.nextInt(101);

        if (rngValue <= 22)
        {
            System.out.println("You have found a health potion!");
            System.out.println("[Max HP +5%, HP Restored]\n");
            player1.setMaxHPBuff(0.05);
            player1.setCurrentHP(player1.getMaxHP());
        }
        else if (rngValue <= 44)
        {
            System.out.println("You have found a strength potion!");
            System.out.println("[Attack +5%]\n");
            player1.setAttackBuff(0.05);
        }
        else if (rngValue <= 66)
        {
            System.out.println("You have found a defense potion!");
            System.out.println("[Defense +5%]\n");
            player1.setDefenseBuff(0.05);
        }
        else if (rngValue <= 88)
        {
            System.out.println("You have found a speed potion!");
            System.out.println("[Speed +5%]\n");
            player1.setSpeedBuff(0.05);
        }
        else
        {
            System.out.println("You have found pile of gold!");
            System.out.println("[Coins 2x]\n");
            player1.setCoins(player1.getCoins() * 2);
        }
        setDescription("Cleared");
    }
}