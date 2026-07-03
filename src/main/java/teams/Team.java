package teams;

import battles.Battle;
import characters.Character;

import java.util.ArrayList;

public class Team {
    private static final int MAX_CHARACTER_NUMBER = 4;
    protected ArrayList<characters.Character> characters = new ArrayList<characters.Character>();

    public Team() {
    }
    /**
     * @param newCharacter:待加入角色
     */
    public void addCharacter(Character newCharacter) {
        //TODO:判断新加入角色是否与已有角色重复
        if (characters.size() < MAX_CHARACTER_NUMBER) {
            characters.add(newCharacter);
        }
    }

    /**
     * @return 返回当前队伍中的角色数
     */
    public int getCharacterNumber() {
        return characters.size();
    }

    /**
     * 判断队伍中是否还有人存活。
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
     * 此方法用于接受Battle传递来的伤害
     *
     * @param damage 伤害数值
     * @param index  伤害接受者的序号，从1到4
     * @throws IllegalArgumentException 如果rank所指代的角色为空
     */
    public void receiveDamage(int index, int damage) {
        if (index > characters.size()) {
            throw new IllegalArgumentException("这里禁止攻击空气。");
        }
        characters.get(index - 1).receiveDamage(damage);
    }

    public void update(Battle battle, Battle.OpponentIndex opponentIndex) {
        for (Character character : characters) {
            int damage = character.getSkill(0).processData(character.getStatus());
            battle.deliverDamage(opponentIndex, 1, damage);
        }
    }
}
