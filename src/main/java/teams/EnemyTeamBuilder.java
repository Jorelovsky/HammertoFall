package teams;

import characters.EnemyBuilder;

public class EnemyTeamBuilder {
    private static final int enemyNumberforTest = 3;
    public static EnemyTeam buildEnemyTeamforTest(){
        EnemyTeam enemyTeam = new EnemyTeam();
        int i = 0;
        while(i < enemyNumberforTest) {
            enemyTeam.addCharacter(EnemyBuilder.buildEnemyforTest());
            i++;
        }
        return enemyTeam;
    }
}
