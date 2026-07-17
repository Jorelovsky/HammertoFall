import characters.Character;
import characters.CharacterFactory;
import characters.CharacterStatus;
import characters.EnemyBuilder;
import fileloader.SkillData;
import fileloader.CharacterData;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterTest {
    private static final Logger logger = LoggerFactory.getLogger(CharacterTest.class);
    @Test
    public void testLevelup(){
        CharacterData.init();
        SkillData.init();
        Character character = EnemyBuilder.buildEnemyforTest();
        int level = 1;
        while(level < 100)
        {
            character.levelUpto(level);
            CharacterStatus status = character.getStatus();
            logger.info("Level:{} Attack:{} Defense:{} MaxHealth:{} Fortune:{}",
                    character.getLevel(),status.attack, status.defense, status.maxHealth, status.fortune);
            level++;
        }
    }
}
