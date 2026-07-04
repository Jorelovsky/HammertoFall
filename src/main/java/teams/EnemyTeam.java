package teams;

import battles.Battle;
import characters.Character;

public class EnemyTeam extends Team {

    @Override
    public void update(Battle.OpponentIndex opponentIndex) {
        Battle battle = Battle.getInstance();
        for (Character character : characters) {
            //TODO:优化敌人出招逻辑。
            //敌人从已有技能中随机出招。
            int damage = character.getSkill((int) Math.floor(Math.random()
                    * (character.getSkillsNumber() - 1))).processData(character.getStatus());
            battle.deliverDamage(opponentIndex, 1, damage);
        }
    }
}
