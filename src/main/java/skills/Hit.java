package skills;

import characters.CharacterStatus;
import fileloader.SkillData;

public class Hit extends Skill {
    public Hit() {
        name = "Hit";
        Multiplier = SkillData.getSkillData(name);
        type = SkillType.ATTACK;
    }

    @Override
    //Hit技能的机制：攻击力*（固有倍率+角色幸运值*随机数）
    public int processData(CharacterStatus status) {
        return (int) Math.round(status.attack * (Multiplier + status.fortune * Math.random()));
    }
}
