package teams;

import accounts.Player;
import accounts.PlayerCommandDecoder;
import battles.Battle;
import characters.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skills.Skill;
import battles.TeamIndex;

import java.util.ArrayList;

public class PlayerTeam extends Team {
    Player player;
    public PlayerTeam(Player player){
        this.player = player;
    }
    private static final Logger logger = LoggerFactory.getLogger(PlayerTeam.class);
    @Override
    public void update(TeamIndex teamIndex) {
        Battle battle = Battle.getInstance();
        int receiverIndex, skillIndex, skillImpact;
        Skill skill;
        int i = 0;
        while(i<characters.size()){
            Character character = characters.get(i);
            logger.info("指定{}的行动喵:", character.getName());
            String playerCommand = player.getPlayerInput();
            ArrayList<Integer> decodedCommand = PlayerCommandDecoder.CommandDecoder(playerCommand);
            if(decodedCommand.size() != 2){
                logger.warn("你指令输错了喵！");
                continue;//输入不合法，i不增加，此轮循环再来一次，下同。
            }
            //TODO:改掉这里0和1的魔法值。
            receiverIndex = decodedCommand.get(0);
            skillIndex = decodedCommand.get(1);
            skill = character.getSkill(skillIndex);
            skillImpact = skill.processData(character.getStatus());
            battle.deliverSkill(teamIndex, receiverIndex, skill.getType(), skillImpact);
            i++;
        }
    }
}
