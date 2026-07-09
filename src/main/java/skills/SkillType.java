package skills;

import battles.TeamIndex;

public enum SkillType {
    ATTACK, HEAL;
    public TeamIndex getReceiverIndex(TeamIndex index){
        switch (this){
            case ATTACK:
                return index.getOpponentIndex();
            case HEAL:
            default:return index;
        }
    }
}
