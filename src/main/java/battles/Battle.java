package battles;

import accounts.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import teams.Team;

import java.util.Scanner;


public class Battle {
    private static Battle INSTANCE = new Battle();
    private Team teamA, teamB;
    private boolean isBattling = false;
    private static final Logger logger = LoggerFactory.getLogger(Battle.class);

    public enum OpponentIndex {
        TEAMA, TEAMB
    }

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
     * 将调用该方法的Team造成的伤害传递到目标Team
     *
     * @param TeamIndex 承受伤害的Team
     * @param index     承受伤害的角色
     * @param damage    造成的伤害
     */
    public void deliverDamage(OpponentIndex TeamIndex, int index, int damage) {
        Team objectTeam = (TeamIndex == OpponentIndex.TEAMA) ? teamA : teamB;
        try{
            objectTeam.receiveDamage(index, damage);
        }catch (IllegalArgumentException exception){
            throw exception;
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
            teamA.update(OpponentIndex.TEAMB);
            teamB.update(OpponentIndex.TEAMA);
            if (!(teamA.isTeamAlive() && teamB.isTeamAlive())) {
                isBattling = false;
            }
        }
        teamA.presentCharactersInfo();
        teamB.presentCharactersInfo();
        logger.info("战斗结束喵！");
    }
}
