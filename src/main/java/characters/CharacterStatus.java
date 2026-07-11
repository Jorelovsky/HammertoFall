package characters;

public class CharacterStatus {
    public final int LOWEST_HEALTH = 0;
    public int maxHealth;
    public int health;
    public int attack;
    public int defense;
    public int fortune;
    public double defenseMultiplier;

    public CharacterStatus() {
    }

    public CharacterStatus(CharacterStatus status) {
        this.maxHealth = status.maxHealth;
        this.health = status.health;
        this.attack = status.attack;
        this.defense = status.defense;
        this.fortune = status.fortune;
        this.defenseMultiplier = status.defenseMultiplier;
    }
}
