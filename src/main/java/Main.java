import battles.Battle;
import characters.Character;
import characters.CharacterFactory;
import skills.GeneralAttack;
import skills.Hit;
import skills.Smash;
import teams.EnemyTeam;
import teams.PlayerTeam;
import teams.Team;

public class Main {
    public static void main(String[] args) {
        String str = "Jorelovsky";
        Player player = new Player(str);
        Character enemy = CharacterFactory.getCharacter("Involver");
        Character hero = CharacterFactory.getCharacter("Involver");
        hero.learnSkill(new GeneralAttack());
        hero.learnSkill(new Hit());
        hero.learnSkill(new Smash());
        enemy.learnSkill(new Hit());
        enemy.learnSkill(new GeneralAttack());
        Team playerTeam = new PlayerTeam();
        playerTeam.addCharacter(hero);
        player.setTeam(playerTeam);
        Team Enemyteam = new EnemyTeam();
        Enemyteam.addCharacter(enemy);
        Battle battle = Battle.getInstance();
        battle.setTeamA(player.getTeam());
        battle.setTeamB(Enemyteam);
        battle.startBattle();
    }

}