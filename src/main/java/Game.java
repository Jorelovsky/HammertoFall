import accounts.Player;
import battles.Battle;
import characters.Character;
import characters.CharacterFactory;
import characters.Involver;
import skills.GeneralAttack;
import skills.Hit;
import skills.Smash;
import teams.EnemyTeam;
import teams.EnemyTeamBuilder;
import teams.PlayerTeam;

public class Game {
    private final static Game INSTANCE = new Game();
    private Player player;
    private Game(){}
    public static Game getInstance(){
        return INSTANCE;
    }
    public void init() {
        player = Player.getInstance();
        System.out.println("请输入您的用户名:");
        player.init(player.getPlayerInput());
        PlayerTeam playerTeam = new PlayerTeam();
        Character hero = CharacterFactory.getCharacter("Involver");
        hero.learnSkill(new GeneralAttack());
        hero.learnSkill(new Smash());
        hero.learnSkill(new Hit());
        playerTeam.addCharacter(hero);
        player.setTeam(playerTeam);
    }
    public void start(){
        Battle battle = Battle.getInstance();
        battle.setTeamA(player.getTeam());
        battle.setTeamB(EnemyTeamBuilder.buildEnemyTeamforTest());
        battle.startBattle();
    }
    public void end(){
        player.destroy();
    }
}
