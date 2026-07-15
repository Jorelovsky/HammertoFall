package skills;

import characters.CharacterStatus;
import fileloader.SkillData;

public class Smash extends Skill {

    public Smash() {
        name = "Smash";
        Multiplier = SkillData.getSkillData(name);
        type = SkillType.ATTACK;
    }

    @Override
    public int processData(CharacterStatus status) {
        return (int) ((status.defense + status.attack) * Multiplier);
    }
}
