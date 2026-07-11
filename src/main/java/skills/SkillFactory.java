package skills;

import characters.Involver;
import characters.Napoleon;

public class SkillFactory {

    public static Skill getSkill(String skillIndex){
        if (skillIndex == null) {
            throw new IllegalArgumentException("这里禁止输入null，谢谢。");
        } else if (skillIndex.equals("GeneralAttack")) {
            return new GeneralAttack();
        } else if (skillIndex.equals("Heal")){
            return new Heal();
        } else if (skillIndex.equals("Hit")) {
            return new Hit();
        } else if (skillIndex.equals("Smash")) {
            return new Smash();
        }
        throw new IllegalArgumentException("查无此技能");
    }
}
