package characters;

import skills.GeneralAttack;
import skills.Hit;
import skills.Smash;

public class EnemyBulider {
    public static characters.Character buildEnemyforTest(){
        characters.Character enemy = CharacterFactory.getCharacter("Involver");
        enemy.learnSkill(new Hit());
        enemy.learnSkill(new Smash());
        enemy.learnSkill(new GeneralAttack());
        return enemy;
    }
}
