package teams;

import battles.Battle;
import characters.Character;

import java.util.Scanner;

public class PlayerTeam extends Team {
    @Override
    public void update(Battle battle, Battle.OpponentIndex opponentIndex) {
        Scanner scanner = new Scanner(System.in);
        int enemyIndex, skillIndex, damage;
        for (Character character : characters) {
            System.out.println("指定" + character.getName() + "的行动:");
            enemyIndex = scanner.nextInt();
            skillIndex = scanner.nextInt();
            damage = character.getSkill(skillIndex - 1).processData(character.getStatus());
            battle.deliverDamage(opponentIndex, enemyIndex, damage);
        }
    }
}
