import java.util.Random;

/**
 * Spider class (type of monster), that creates a spider with stats based on the player's stats
 */
public class Spider extends Monster
{
    private static final Random randStats = new Random();

    /**
     * Creates a spider with stats based on the player's stats (so it scales with the player)
     * @param player1   the player
     */
    public Spider(Hero player1)
    {
        super((player1.getMaxHP() / 1.8) + (player1.getMaxHP() * randStats.nextInt(-5,6) / 100),
                (player1.getAttack() / 1.735) + (player1.getAttack() * randStats.nextInt(-5, 6) / 100),
                (player1.getDefense() / 1.25) + (player1.getDefense() * randStats.nextInt(-5, 6) / 100),
                (player1.getSpeed() * 1.2) + (player1.getSpeed() * randStats.nextInt(-5, 6) / 100),
                (player1.getCoins() / 10) + (player1.getCoins() * randStats.nextInt(-2, 3) / 100),
                (int) ((player1.getLevel()) + (player1.getLevel() * randStats.nextInt(6) / 100)),
                (randStats.nextInt(40, 60)));
    }
}