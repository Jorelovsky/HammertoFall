package skills;

import characters.CharacterStatus;

public class Smash extends Skill {
    private final double attackMultiplier = 3.0;

    public Smash() {
        name = "Smash";
        type = SkillType.ATTACK;
    }

    @Override
    public int processData(CharacterStatus status) {
        return (int) ((status.defense + status.attack) * attackMultiplier);
    }
}
