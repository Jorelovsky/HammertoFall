package battles;

import characters.Character;
import characters.CharacterStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skills.Skill;
import skills.SkillType;
import teams.Team;

public class Battle {
    private static final Battle INSTANCE = new Battle();
    private Team teamA, teamB;
    private boolean isBattling = false;
    private static final Logger logger = LoggerFactory.getLogger(Battle.class);


    public static Battle getInstance() {
        return INSTANCE;
    }

    /**
     * 指定对战中的A队
     *
     * @param teamA 所指定的队伍
     * @throws IllegalArgumentException 如果传入的teamA为null
     */
    public void setTeamA(Team teamA) {
        if (teamA == null) {
            throw new IllegalArgumentException("这里禁止空气来比赛喵");
        } else if (isBattling) {
            throw new RuntimeException("当前无法设置喵。");
        }
        this.teamA = teamA;
    }

    /**
     * 指定对战中的B队
     *
     * @param teamB 所指定的队伍
     * @throws IllegalArgumentException 如果传入的teamA为null
     */
    public void setTeamB(Team teamB) {
        if (teamB == null) {
            throw new IllegalArgumentException("这里禁止空气来比赛喵。");
        } else if (isBattling) {
            throw new RuntimeException("当前无法设置喵。");
        }
        this.teamB = teamB;
    }

    public Team getTeam(TeamIndex index) {
        return index == TeamIndex.TEAMA ? teamA : teamB;
    }

    public void deliverSkill(TeamIndex teamIndex, int receiverIndex, SkillType type, int skillImpact) {
        Team objectTeam = this.getTeam(type.getReceiverIndex(teamIndex));
        Character character = objectTeam.getCharacter(receiverIndex);
        switch (type) {
            case SkillType.ATTACK -> character.receiveDamage(skillImpact);
            case SkillType.HEAL -> character.receiveHealing(skillImpact);
        }
    }


    public void startBattle() {
        if (teamA == null || teamB == null) {
            throw new RuntimeException("请先指定谁来对战喵。");
        }
        if (isBattling) return;
        isBattling = true;
        logger.info("战斗开始喵！");
        while (isBattling) {
            teamA.presentCharactersInfo();
            teamB.presentCharactersInfo();
            teamA.update(TeamIndex.TEAMA);
            teamB.update(TeamIndex.TEAMB);
            if (!(teamA.isTeamAlive() && teamB.isTeamAlive())) {
                isBattling = false;
            }
        }
        teamA.presentCharactersInfo();
        teamB.presentCharactersInfo();
        logger.info("战斗结束喵！");
    }
}
