package skills;

import characters.CharacterStatus;
import fileloader.SkillData;

public class GeneralAttack extends Skill {
    public GeneralAttack() {
        name = "GeneralAttack";
        Multiplier = SkillData.getSkillData(name);
        type = SkillType.ATTACK;
    }

    @Override
    public int processData(CharacterStatus status) {
        return (int)(status.attack * Multiplier);
    }
}
