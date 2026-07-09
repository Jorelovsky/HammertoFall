package skills;

import characters.CharacterStatus;

public class GeneralAttack extends Skill {
    public GeneralAttack() {
        name = "GeneralAttack";
        type = SkillType.ATTACK;
    }

    @Override
    public int processData(CharacterStatus status) {
        return status.attack;
    }
}
