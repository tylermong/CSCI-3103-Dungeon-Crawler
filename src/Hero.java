/**
 * Hero class that represents the player, that has methods for leveling up, battling, and printing stats
 */
public class Hero extends Entity
{
    private double maxHP, currentHP, attack, defense, speed, coins, level, experience;
    private double maxHPBuff = 1, attackBuff = 1, defenseBuff = 1, speedBuff = 1;

    /**
     * Creates a hero with base stats
     */
    public Hero()
    {
        super("Hero");
        maxHP = 100;
        currentHP = 100;
        attack = 10;
        defense = 10;
        speed = 10;
        coins = 10;
        level = 1;
        experience = 0;
    }

    /**
     * Gets the max HP of the hero
     * @return  the max HP
     */
    public double getMaxHP()
    {
        return maxHP;
    }

    /**
     * Gets the current HP of the hero
     * @return  the current HP
     */
    public double getCurrentHP()
    {
        return currentHP;
    }

    /**
     * Gets the attack of the hero
     * @return  the attack
     */
    public double getAttack()
    {
        return attack;
    }

    /**
     * Gets the defense of the hero
     * @return  the defense
     */
    public double getDefense()
    {
        return defense;
    }

    /**
     * Gets the speed of the hero
     * @return  the speed
     */
    public double getSpeed()
    {
        return speed;
    }

    /**
     * Gets the coins of the hero
     * @return  the coins
     */
    public double getCoins()
    {
        return coins;
    }

    /**
     * Gets the level of the hero
     * @return  the level
     */
    public double getLevel()
    {
        return level;
    }

    /**
     * Sets the current HP of the hero
     * @param currentHP the new current HP
     */
    public void setCurrentHP(double currentHP)
    {
        this.currentHP = currentHP;
    }

    /**
     * Sets the coins of the hero
     * @param coins the new coins
     */
    public void setCoins(double coins)
    {
        this.coins = coins;
    }

    /**
     * Sets the max HP buff of the hero
     * @param buffAmount    the new max HP buff
     */
    public void setMaxHPBuff(double buffAmount)
    {
        maxHPBuff += buffAmount;
    }

    /**
     * Sets the attack buff of the hero
     * @param buffAmount    the new attack buff
     */
    public void setAttackBuff(double buffAmount)
    {
        attackBuff += buffAmount;
    }

    /**
     * Sets the defense buff of the hero
     * @param buffAmount    the new defense buff
     */
    public void setDefenseBuff(double buffAmount)
    {
        defenseBuff += buffAmount;
    }

    /**
     * Sets the speed buff of the hero
     * @param buffAmount    the new speed buff
     */
    public void setSpeedBuff(double buffAmount)
    {
        speedBuff += buffAmount;
    }

    /**
     * Performs calculation when the hero levels up
     */
    public void levelUp()
    {
        double preHP = maxHP, preAttack = attack, preDefense = defense, preSpeed = speed, preLevel = level;
        final double startingHP = 100, startingAttack = 10, startingDefense = 10, startingSpeed = 10;
        final double growthRate = 0.5;

        level++;
        maxHP = (int) ((startingHP * Math.exp(growthRate * Math.log(level))) * maxHPBuff);
        currentHP = maxHP;
        attack = (int) ((startingAttack * Math.exp(growthRate * Math.log(level))) * attackBuff);
        defense = (int) ((startingDefense * Math.exp(growthRate * Math.log(level))) * defenseBuff);
        speed = (int) ((startingSpeed * Math.exp(growthRate * Math.log(level))) * speedBuff);
        experience -= 100;

        levelUpPrompt(preHP, maxHP, preAttack, attack, preDefense, defense, preSpeed, speed, preLevel, level);          // prints the level up prompt
    }

    /**
     * Prints the level up prompt
     * @param preHP         HP before level up
     * @param postHP        HP after level up
     * @param preAttack     attack before level up
     * @param postAttack    attack after level up
     * @param preDefense    defense before level up
     * @param postDefense   defense after level up
     * @param preSpeed      speed before level up
     * @param postSpeed     speed after level up
     * @param preLevel      level before level up
     * @param postLevel     level after level up
     */
    public void levelUpPrompt(double preHP, double postHP, double preAttack, double postAttack, double preDefense, double postDefense, double preSpeed, double postSpeed, double preLevel, double postLevel)
    {
        System.out.println("\nLEVEL UP");
        System.out.println("Level\t" + (int) preLevel + " -> " + (int) postLevel);
        System.out.println("Max HP\t" + preHP + " -> " + postHP);
        System.out.println("Attack\t" + preAttack + " -> " + postAttack);
        System.out.println("Defense\t" + preDefense + " -> " + postDefense);
        System.out.println("Speed\t" + preSpeed + " -> " + postSpeed);
    }

    /**
     * Battles a monster
     * @param monster   the monster
     */
    public void battle(Monster monster)
    {
        System.out.println("Monster Stats: ");          // prints the stats of both the player and monster before the fight
        monster.printBattleStats();
        System.out.println("\n\nYour Stats: ");
        printStats();
        if (monster.getSpeed() < speed)                 // determines who attacks first depending on who has the greater speed
        {
            System.out.println("\nYou are faster than the monster... you attack first!");
            playerAttackFirst(monster);
        }
        else
        {
            System.out.println("\nThe monster is faster than you... the monster attacks first!");
            monsterAttackFirst(monster);
        }
    }

    /**
     * Battle when the player attacks first (player speed > monster speed)
     * @param monster   the monster
     */
    public void playerAttackFirst(Monster monster)
    {
        while (currentHP > 0 && monster.getHP() > 0)
        {
            System.out.println("\nYou attacked the monster!");
            monster.setHP(monster.getHP() - (attack - (monster.getDefense() / 2)));
            System.out.printf("Monster HP: %.2f\n", monster.getHP());
            if (monster.getHP() <= 0)
            {
                System.out.println("You have slain the monster!");
                experience += monster.getExperience();
                System.out.printf("You gained %.2f experience!", monster.getExperience());
                coins += monster.getCoins();
                System.out.printf("\nYou gained %.2f coins!\n", monster.getCoins());
                if (experience >= 100)
                    levelUp();
                setDescription("Cleared");
                System.out.println();
                break;
            }

            System.out.println("\nThe monster attacked you!");
            currentHP -= (monster.getAttack() - (defense / 5));
            System.out.printf("Your HP: %.2f\n", currentHP);
            if (currentHP <= 0)
            {
                System.out.println("\nYou have been defeated by the monster!");
                System.out.println("Ending Stats: ");
                printStats();
                System.exit(0);

            }
        }
    }

    /**
     * Battle when the monster attacks first (monster speed > player speed)
     * @param monster   the monster
     */
    public void monsterAttackFirst(Monster monster)
    {
        while (currentHP > 0 && monster.getHP() > 0)
        {
            System.out.println("\nThe monster attacked you!");
            currentHP -= (monster.getAttack() - (defense / 5));
            System.out.printf("Your HP: %.2f\n", currentHP);
            if (currentHP <= 0)
            {
                System.out.println("\nYou have been defeated by the monster!");
                System.out.println("Ending Stats: ");
                printStats();
                System.exit(0);
            }

            System.out.println("\nYou attacked the monster!");
            monster.setHP(monster.getHP() - (attack - (monster.getDefense() / 2)));
            System.out.printf("Monster HP: %.2f\n", monster.getHP());
            if (monster.getHP() <= 0)
            {
                System.out.println("\nYou have slain the monster!");
                experience += monster.getExperience();
                System.out.printf("You gained %.2f experience!", monster.getExperience());
                coins += monster.getCoins();
                System.out.printf("\nYou gained %.2f coins!\n", monster.getCoins());
                if (experience >= 100)
                    levelUp();
                setDescription("Cleared");
                System.out.println();
                break;
            }
        }
    }

    /**
     * Prints the stats of the hero
     */
    public void printStats()
    {
        System.out.printf("HP: %.2f/%.2f", currentHP, maxHP);
        System.out.printf("\nAttack: %.2f", attack);
        System.out.printf("\nDefense: %.2f", defense);
        System.out.printf("\nSpeed: %.2f", speed);
        System.out.printf("\nCoins: %.2f", coins);
        System.out.printf("\nLevel: %.2f", level);
        System.out.printf("\nExperience: %.2f/100\n", experience);
    }
}