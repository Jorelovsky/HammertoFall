package accounts;

import teams.Team;

import java.util.Scanner;

public class Player {
    private String playerName;
    private Team team = new Team();
    private static final Player INSTANCE = new Player();
    private Scanner inputScanner = new Scanner(System.in);

    private Player() {
    }
    public static Player getInstance(){
        return INSTANCE;
    }

    /**
     * 初始化玩家账户
     * @param playerName 新建用户名
     */
    public void init(String playerName) {
        this.playerName = playerName;
        System.out.println(playerName + "加入战场。");
    }

    public void destroy(){
        inputScanner.close();
    }
    /**
     * 设置玩家所拥有的队伍
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public String getPlayerInput(){
        String input = inputScanner.nextLine();
        return input;
    }
}
