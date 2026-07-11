package skills;

public class SkillFactory {

    /**
     * 获取技能实例
     *
     * @param skillIndex 技能名
     * @return 技能名对应的技能实例
     */
    public static Skill getSkill(String skillIndex) {
        if (skillIndex == null) {
            throw new IllegalArgumentException("这里禁止输入null，谢谢。");
        } else if (skillIndex.equals("GeneralAttack")) {
            return new GeneralAttack();
        } else if (skillIndex.equals("Heal")) {
            return new Heal();
        } else if (skillIndex.equals("Hit")) {
            return new Hit();
        } else if (skillIndex.equals("Smash")) {
            return new Smash();
        }
        throw new IllegalArgumentException("查无此技能");
    }
}
