package battles;

import characters.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * 根据队伍索引获得当前对战对应的队伍
     *
     * @param index 队伍索引
     * @return 当前对战对应的队伍
     */
    public Team getTeam(TeamIndex index) {
        return index == TeamIndex.TEAMA ? teamA : teamB;
    }

    /**
     * 执行角色技能的效果
     *
     * @param teamIndex     技能由哪一队发出
     * @param receiverIndex 技能效果承受者在其所在队伍中的序号
     * @param type          技能类型
     * @param skillImpact   技能造成的影响（伤害、治疗）
     */
    public void deliverSkill(TeamIndex teamIndex, int receiverIndex, SkillType type, int skillImpact) {
        Team objectTeam = this.getTeam(type.getReceiverIndex(teamIndex));
        Character character = objectTeam.getCharacter(receiverIndex);
        switch (type) {
            case SkillType.ATTACK -> character.receiveDamage(skillImpact);
            case SkillType.HEAL -> character.receiveHealing(skillImpact);
        }
    }

    /**
     * 开始战斗
     */
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
