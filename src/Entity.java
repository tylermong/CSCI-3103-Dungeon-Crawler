/**
 * Represents an entity in the game, including the player, enemies, and loot
 */

public class Entity
{
    private String description;

    /**
     * Creates an entity
     * @param entityName    the name/description of the entity
     */
    public Entity(String entityName)
    {
        description = entityName;
    }

    /**
     * Sets the description of the entity
     * @param updatedDescription    the new description
     */
    public void setDescription(String updatedDescription)
    {
        description = updatedDescription;
    }

    /**
     * Gets the description of the entity
     * @return  the description
     */
    public String getDescription()
    {
        return description;
    }
}