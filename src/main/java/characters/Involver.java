package characters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Involver是卷狗的意思
public class Involver extends Character {
    private final double defenceMultiplier = 1.2;
    private static final Logger logger = LoggerFactory.getLogger(Involver.class);

    public Involver() {
        this.name = "Involver";
        this.status = new CharacterStatus(CharacterData.characterStatusFactory(this.name));
        this.status.health = this.status.maxHealth;

    }

    @Override
    public void receiveDamage(int damage) {
        //Involver承伤机制：实际伤害 = 受到伤害 - 防御力 * 承伤倍率
        int actualDamage = Math.max(0, damage - (int) (status.defense * defenceMultiplier));
        this.status.health = Math.max(this.status.health - actualDamage, this.status.LOWEST_HEALTH);
        logger.info("{}受到{}的伤害喵！", name, actualDamage);
    }
}
