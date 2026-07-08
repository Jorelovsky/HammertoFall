package accounts;

import org.slf4j.LoggerFactory;
import teams.Team;

import java.util.Scanner;
import org.slf4j.Logger;

public class Player {
    private String playerName;
    private Team team;
    private Scanner inputScanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    public Player() {
    }
    /**
     * 初始化玩家账户
     * @param playerName 新建用户名
     */
    public void init(String playerName) {
        this.playerName = playerName;
        logger.info(playerName + "加入战场喵。");
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
