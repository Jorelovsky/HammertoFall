package battles;

import teams.Team;

import java.util.Scanner;


public class Battle {
    private static Battle instance = new Battle();
    private Team teamA, teamB;
    private boolean isBattling = false;

    public enum OpponentIndex {
        TEAMA, TEAMB;
    }

    public static Battle getInstance() {
        return instance;
    }


    /**
     * 指定对战中的A队，下面的setTeamB同理
     *
     * @param teamA 所指定的队伍
     * @return 设置成功为true,设置失败为false
     * @throws IllegalArgumentException 如果传入的teamA为null
     */
    public boolean setTeamA(Team teamA) {
        if (teamA == null) {
            throw new IllegalArgumentException("这里禁止空气来比赛，谢谢。");
        } else if (isBattling) {
            return false;
        }
        this.teamA = teamA;
        return true;
    }
    /**
     * 指定对战中的A队，下面的setTeamB同理
     *
     * @param teamB 所指定的队伍
     * @return 设置成功为true,设置失败为false
     * @throws IllegalArgumentException 如果传入的teamA为null
     */
    public boolean setTeamB(Team teamB) {
        if (teamB == null) {
            throw new IllegalArgumentException("这里禁止空气来比赛，谢谢。");
        } else if (isBattling) {
            return false;
        }
        this.teamB = teamB;
        return true;
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
        objectTeam.receiveDamage(index, damage);
    }

    public void startBattle() {
        if (teamA == null || teamB == null) {
            throw new RuntimeException("请先指定谁来对战。");
        }
        if (isBattling) return;
        isBattling = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("战斗开始！");
        while (isBattling) {
            teamA.update(this, OpponentIndex.TEAMA);
            teamB.update(this, OpponentIndex.TEAMB);
            if (!(teamA.isTeamAlive() && teamB.isTeamAlive())) {
                isBattling = false;
            }
            //FIXME:这里开了两个scanner
            scanner.nextLine();
        }
        System.out.println("战斗结束！");
        scanner.close();
    }
}
