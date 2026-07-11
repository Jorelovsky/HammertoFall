package teams;

import characters.EnemyBuilder;

public class EnemyTeamBuilder {
    private static final int enemyNumberforTest = 3;

    /**
     * 构建一支标准的敌人队伍用于测试
     *
     * @return 标准敌人队伍
     */
    public static EnemyTeam buildEnemyTeamforTest() {
        EnemyTeam enemyTeam = new EnemyTeam();
        enemyTeam.setName("敌人的队伍");
        int i = 0;
        while (i < enemyNumberforTest) {
            enemyTeam.addCharacter(EnemyBuilder.buildEnemyforTest());
            i++;
        }
        return enemyTeam;
    }
}
