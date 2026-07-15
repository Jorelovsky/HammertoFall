package characters;

import fileloader.CharacterData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Napoleon extends Character{
    private static final Logger logger = LoggerFactory.getLogger(Involver.class);

    public Napoleon() {
        this.name = "Napoleon";
        this.status = new CharacterStatus(CharacterData.getcharacterStatus(this.name));
        this.status.health = this.status.maxHealth;

    }

    @Override
    public void receiveDamage(int damage) {
        //Napoleon承伤机制：实际伤害 = 受到伤害 - （防御力 + 幸运值） * 承伤倍率
        int actualDamage = (int) Math.max(0, damage - (status.defense + status.fortune) * status.defenseMultiplier);
        this.status.health = Math.max(this.status.health - actualDamage, this.status.LOWEST_HEALTH);
        logger.info("{}受到{}的伤害喵！", name, actualDamage);
    }
}
