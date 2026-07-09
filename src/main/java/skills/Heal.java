package skills;

import characters.CharacterStatus;

public class Heal extends Skill{
    private final double healMultiplier = 0.4;
    public Heal(){
        name = "Heal";
        type = SkillType.HEAL;
    }
    @Override
    public int processData(CharacterStatus status){
        return (int)(status.health * healMultiplier);
    }
}
