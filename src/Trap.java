import java.util.Random;

/**
 * Trap room that debuffs player stats
 */
public class Trap extends Entity
{
    public Trap()
    {
        super("Trap");
    }

    /**
     * Debuffs the player's stats
     * @param player1   the player
     */
    public void trapEvent(Hero player1)
    {
        Random rand = new Random();
        int rngValue = rand.nextInt(101);

        if (rngValue <= 22)
        {
            System.out.println("You have inhaled a poison gas!");
            System.out.println("[Max HP -5%]\n");
            player1.setMaxHPBuff(0.05 * -1);
        }
        else if (rngValue <= 44)
        {
            System.out.println("You have jammed a finger!");
            System.out.println("[Attack -5%]\n");
            player1.setAttackBuff(0.05 * -1);
        }
        else if (rngValue <= 66)
        {
            System.out.println("You feel a sharp pain in your chest!");
            System.out.println("[Defense -5%]\n");
            player1.setDefenseBuff(0.05 * -1);
        }
        else if (rngValue <= 88)
        {
            System.out.println("A wizard cast a spell that filled your boots with lead!");
            System.out.println("[Speed -5%]\n");
            player1.setSpeedBuff(0.05 * -1);
        }
        else
        {
            System.out.println("Your coin purse tore open!");
            System.out.println("[Coins 0.5x]\n");
            player1.setCoins(player1.getCoins() / 2);
        }
        setDescription("Cleared");
    }
}