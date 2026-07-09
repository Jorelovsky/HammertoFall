package game;

import accounts.Player;
import battles.Battle;
import characters.Character;
import characters.CharacterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skills.GeneralAttack;
import skills.Hit;
import skills.Skill;
import skills.Smash;
import teams.EnemyTeamBuilder;
import teams.PlayerTeam;

public class Game {
    private Player player;
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    public Game(){}
    public void init() {
        player = new Player();
        logger.info("请输入您的用户名喵:");
        String username = player.getPlayerInput();
        player.init(username);
        PlayerTeam playerTeam = new PlayerTeam(player);
        playerTeam.setName(username + "的队伍");
        Character hero = CharacterFactory.getCharacter("Involver");
        hero.learnSkill(new GeneralAttack());
        hero.learnSkill(new Smash());
        hero.learnSkill(new Hit());
        playerTeam.addCharacter(hero);
        player.setTeam(playerTeam);
        Skill.init();
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
