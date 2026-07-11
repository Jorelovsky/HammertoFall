package characters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Napoleon extends Character{
    private static final Logger logger = LoggerFactory.getLogger(Involver.class);

    public Napoleon() {
        this.name = "Napoleon";
        this.status = new CharacterStatus(CharacterData.characterStatusFactory(this.name));
        this.status.health = this.status.maxHealth;

    }

    @Override
    public void receiveDamage(int damage) {
        int actualDamage = Math.max(0, damage - (status.defense ));
        this.status.health = Math.max(this.status.health - actualDamage, this.status.LOWEST_HEALTH);
        logger.info("{}受到{}的伤害喵！", name, actualDamage);
    }
}
