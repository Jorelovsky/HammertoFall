package characters;

import skills.SkillFactory;


public class EnemyBuilder {
    /**
     * 构建一个标准的敌人用于测试
     *
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
