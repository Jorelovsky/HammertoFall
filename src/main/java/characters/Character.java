package characters;

import skills.Skill;

import java.util.ArrayList;

abstract public class Character {
    protected String name;

    protected final int MAX_SKILL_NUMBER = 4;

    protected CharacterStatus status;

    protected ArrayList<Skill> skills = new ArrayList<Skill>();


    /**
     * 外部获得角色当前名称
     *
     * @return 角色当前名称；
     */
    public String getName() {
        return name;
    }

    /**
     * 外部获知角色是否存活
     *
     * @return true为活着，false为死了。
     */
    public boolean isAlive() {
        return status.health > status.LOWEST_HEALTH;
    }

    /**
     * 外部获取角色当前技能数量
     *
     * @return 技能数
     */
    public int getSkillsNumber() {
        return skills.size();
    }

    /**
     * 外部获取角色的指定技能
     *
     * @param index 要获取的技能编号，从0开始
     * @return 所获取的技能
     * @exception IllegalArgumentException 传入的index为负数或大于拥有技能数-1
     */
    public Skill getSkill(int index) {
        if (index < skills.size()) {
            Skill skill = skills.get(index);
            System.out.println(name + "使用了" + skill.name);
            return skill;
        } else throw new IllegalArgumentException("没有这个技能喵");
    }

    /**
     * 让角色学习技能
     * @param skill 外部传入的技能
     */
    public void learnSkill(Skill skill) {
        if (skill == null) {
            throw new IllegalArgumentException("空气不用学习喵");
        } else if (skills.size() >= MAX_SKILL_NUMBER) {
            throw new RuntimeException(name + "脑子有限，学不会这么多技能喵");
        } else {
            skills.add(skill);
            System.out.println(name + "学会了" + skill.name + "喵");
        }
    }

    /**
     * 外部获取角色面板
     *
     * @return 该角色的面板
     */
    public CharacterStatus getStatus() {
        return status;
    }

    /**
     * 角色承伤机制
     *
     * @param damage 受到的伤害
     */
    abstract public void receiveDamage(int damage);
}
