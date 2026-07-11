package characters;

import skills.GeneralAttack;
import skills.Hit;
import skills.SkillFactory;
import skills.Smash;

public class EnemyBuilder {
    /**
     * 构建一个标准的敌人用于测试
     * @return 标准敌人
     */
    public static characters.Character buildEnemyforTest() {
        characters.Character enemy = CharacterFactory.getCharacter("Involver");
        enemy.learnSkill(SkillFactory.getSkill("Hit"));
        enemy.learnSkill(SkillFactory.getSkill("Smash"));
        enemy.learnSkill(SkillFactory.getSkill("GeneralAttack"));
        return enemy;
    }
}
