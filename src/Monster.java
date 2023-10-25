/**
 * Monster class, currently only used for the Spider class, but can be expanded to include more monsters in the future
 */

public class Monster extends Entity
{
    private double HP;
    private final double attack, defense, speed, coins, level, experience;

    /**
     * Creates a monster
     * @param HP            the HP of the monster
     * @param attack        the attack of the monster
     * @param defense       the defense of the monster
     * @param speed         the speed of the monster
     * @param coins         the coins the monster drops
     * @param level         the level of the monster
     * @param experience    the experience the monster drops
     */
    public Monster(double HP, double attack, double defense, double speed, double coins, double level, double experience)
    {
        super("Monster");
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.coins = coins;
        this.level = level;
        this.experience = experience;
    }

    /**
     * Gets the HP of the monster
     * @return  the HP
     */
    public double getHP()
    {
        return HP;
    }

    /**
     * Sets the HP of the monster
     * @param newHP the new HP
     */
    public void setHP(double newHP)
    {
        HP = newHP;
    }

    /**
     * Gets the attack of the monster
     * @return  the attack
     */
    public double getAttack()
    {
        return attack;
    }

    /**
     * Gets the defense of the monster
     * @return  the defense
     */
    public double getDefense()
    {
        return defense;
    }

    /**
     * Gets the speed of the monster
     * @return  the speed
     */
    public double getSpeed()
    {
        return speed;
    }

    /**
     * Gets the coins of the monster
     * @return  the coins
     */
    public double getCoins()
    {
        return coins;
    }

    /**
     * Gets the level of the monster
     * @return  the level
     */
    public double getExperience()
    {
        return experience;
    }

    /**
     * Prints the monster's stats for a battle
     */
    public void printBattleStats()
    {
        System.out.printf("HP: %.2f", HP);
        System.out.printf("\nAttack: %.2f", attack);
        System.out.printf("\nDefense: %.2f", defense);
        System.out.printf("\nSpeed: %.2f", speed);
        System.out.printf("\nCoins: %.2f", coins);
        System.out.printf("\nLevel: %.2f", level);
        System.out.printf("\nExperience: %.2f/100", experience);
    }
}