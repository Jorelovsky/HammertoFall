package teams;

import characters.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import battles.TeamIndex;

import java.util.ArrayList;

public abstract class Team {
    private String name = "Unnamed";
    private static final int MAX_CHARACTER_NUMBER = 4;
    protected ArrayList<characters.Character> characters = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Team.class);

    /**
     * 向队伍中添加角色
     *
     * @param newCharacter:待加入角色
     */
    public void addCharacter(Character newCharacter) {
        //TODO:判断新加入角色是否与已有角色重复
        if (characters.size() < MAX_CHARACTER_NUMBER) {
            characters.add(newCharacter);
        }
    }

    /**
     * 获取队伍角色数
     *
     * @return 返回当前队伍中的角色数
     */
    public int getCharacterNumber() {
        return characters.size();
    }

    /**
     * 设置队伍的名称
     *
     * @param name 新名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取队伍的名称
     *
     * @return 队伍名称
     */
    public String getName() {
        return name;
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }

    /**
     * 判断队伍中是否还有角色存活。
     *
     * @return true是活着，false是全死了。
     */
    public boolean isTeamAlive() {
        for (Character character : characters) {
            if (character.isAlive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 战斗中每回合调用。
     *
     * @param teamIndex 队伍的标识
     */
    public abstract void update(TeamIndex teamIndex);

    /**
     * 呈现当前队伍状态
     */
    public void presentCharactersInfo() {
        logger.info(name);
        for (int i = 0; i < this.characters.size(); i++) {
            Character character = this.characters.get(i);
            logger.info("{}.{} 生命值: {}", i, character.getName(), character.getStatus().health);
        }
    }
}
