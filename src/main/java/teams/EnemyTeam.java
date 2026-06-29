package teams;

import battles.Battle;
import characters.Character;

public class EnemyTeam extends Team {

    @Override
    public void update(Battle battle, Battle.OpponentIndex opponentIndex) {
        for (Character character : characters) {
            int damage = character.getSkill((int) Math.floor(Math.random()
                    * (character.getSkillsNumber() - 1))).processData(character.getStatus());
            battle.deliverDamage(opponentIndex, 1, damage);
        }
    }
}
