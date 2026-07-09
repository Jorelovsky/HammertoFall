package skills;

import characters.CharacterStatus;

public class Hit extends Skill {
    private final double attackMultiplier = 1.5;

    public Hit() {
        name = "Hit";
        type = SkillType.ATTACK;
    }

    @Override
    //Hit技能的机制：攻击力*（固有倍率+角色幸运值*随机数）
    public int processData(CharacterStatus status) {
        return (int) Math.round(status.attack * (attackMultiplier + status.fortune * Math.random()));
    }
}
