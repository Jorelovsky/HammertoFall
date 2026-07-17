package accounts;

import org.slf4j.LoggerFactory;
import teams.Team;

import java.util.Scanner;

import org.slf4j.Logger;

public class Player {
    private static boolean INIT_LOCK = false;
    private String playerName;
    private Team team;
    private final Scanner inputScanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    public Player() {
    }

    /**
     * 初始化玩家账户
     *
     * @param playerName 新建用户名
     */
    public void init(String playerName) {
        if(INIT_LOCK) return;
        INIT_LOCK = true;
        this.playerName = playerName;
        logger.info("{}加入战场喵。", playerName);
    }

    public void destroy() {
        inputScanner.close();
        INIT_LOCK = false;
    }

    /**
     * 设置玩家所拥有的队伍
     *
     * @param team 新队伍
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * 获取玩家当前队伍
     *
     * @return 玩家当前队伍
     */
    public Team getTeam() {
        return team;
    }

    /**
     * 获取玩家在控制台的输入
     *
     * @return 玩家输入的一整行内容
     */
    public String getPlayerInput() {
        String input = inputScanner.nextLine();
        return input;
    }
}
