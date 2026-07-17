package teams;

import battles.Battle;
import characters.Character;
import battles.TeamIndex;
import skills.Skill;

public class EnemyTeam extends Team {

    @Override
    public void update(TeamIndex teamIndex) {
        Battle battle = Battle.getInstance();
        Skill skill;
        for (Character character : characters) {
            //TODO:优化敌人出招逻辑。
            //敌人从已有技能中随机出招。
            if (!character.isAlive()) continue;
            skill = character.getSkill((int) Math.floor(Math.random()
                    * (character.getSkillsNumber())));
            int skillImpact = skill.processData(character.getStatus());
            battle.deliverSkill(teamIndex, 0, skill.getType(), skillImpact);
        }
    }
}
