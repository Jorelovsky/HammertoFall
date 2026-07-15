package skills;

import characters.CharacterStatus;

abstract public class Skill {
    protected String name;
    protected double Multiplier;
    SkillType type;
    /**
     * 获取技能名称
     *
     * @return 技能的名称
     */
    public String getName() {
        return name;
    }

    public SkillType getType() {
        return type;
    }

    /**
     *
     * @param status 角色面板
     * @return 根据该技能机制给出的实际造成伤害的值
     */
    abstract public int processData(CharacterStatus status);
}
