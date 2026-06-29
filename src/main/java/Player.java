import teams.Team;

public class Player {
    private String userName;
    private Team team = new Team();

    /**
     * @param userName 新建用户名
     *
     */
    Player(String userName) {
        this.userName = userName;
        System.out.println(userName + "加入战场。");
    }

    void setTeam(Team team) {
        this.team = team;
    }

    Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return userName;
    }
}
