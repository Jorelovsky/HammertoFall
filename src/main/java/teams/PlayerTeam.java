package teams;

import accounts.Player;
import accounts.PlayerCommandDecoder;
import battles.Battle;
import characters.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerTeam extends Team {
    Player player;
    public PlayerTeam(Player player){
        this.player = player;
    }
    @Override
    public void update(Battle.OpponentIndex opponentIndex) {
        Battle battle = Battle.getInstance();
        int enemyIndex, skillIndex, damage;
        int i = 0;
        while(i<characters.size()){
            Character character = characters.get(i);
            System.out.println("指定" + character.getName() + "的行动喵:");
            String playerCommand = player.getPlayerInput();
            ArrayList<Integer> decodedCommand = PlayerCommandDecoder.CommandDecoder(playerCommand);
            if(decodedCommand.size() != 2){
                System.out.println("你指令输错了喵！");
                continue;//输入不合法，i不增加，此轮循环再来一次，下同。
            }
            //TODO:改掉这里0和1的魔法值。
            enemyIndex = decodedCommand.get(0);
            skillIndex = decodedCommand.get(1);
            try {
                damage = character.getSkill(skillIndex - 1).processData(character.getStatus());
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage() + ",请重新输入喵");
                continue;
            }
            try{
                battle.deliverDamage(opponentIndex, enemyIndex, damage);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage() + ",请重新输入喵");
                continue;
            }
            i++;
        }
    }
}
