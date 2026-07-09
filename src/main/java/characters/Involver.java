package characters;

import accounts.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Involver是卷狗的意思
public class Involver extends Character {
    private final double defenceMultiplier = 1.2;
    private static final Logger logger = LoggerFactory.getLogger(Involver.class);
    public Involver() {
        name = "Involver";
        status = new CharacterStatus();
        status.maxHealth = 100;
        status.health = status.maxHealth;
        status.attack = 10;
        status.defense = 5;
        status.fortune = 5;
    }

    @Override
    public void receiveDamage(int damage) {
        //Involver承伤机制：实际伤害 = 受到伤害 - 防御力 * 承伤倍率
        int actualDamage = Math.max(0, damage - (int) (status.defense * defenceMultiplier));
        status.health = Math.max(status.LOWEST_HEALTH, status.health - actualDamage);
        logger.info("{}受到{}的伤害喵！", name, actualDamage);
    }
}
