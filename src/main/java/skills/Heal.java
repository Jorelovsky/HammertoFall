package skills;

import characters.CharacterStatus;
import fileloader.SkillData;

public class Heal extends Skill {

    public Heal() {
        name = "Heal";
        Multiplier = SkillData.getSkillData(name);
        type = SkillType.HEAL;
    }

    @Override
    public int processData(CharacterStatus status) {
        return (int) (status.health * Multiplier);
    }
}
