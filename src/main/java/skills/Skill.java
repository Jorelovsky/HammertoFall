package skills;

import characters.CharacterStatus;

abstract public class Skill {
    public String name;

    /**
     *
     * @param status 角色面板
     * @return 根据该技能机制给出的实际造成伤害的值
     */
    abstract public int processData(CharacterStatus status);
}
