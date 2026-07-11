package skills;

import battles.TeamIndex;

public enum SkillType {
    ATTACK, HEAL;

    /**
     * 给出该技能类型下技能接受者的队伍索引
     *
     * @param index 技能释放者队伍索引
     * @return 攻击型技能返回对手队伍索引，治疗型技能返回己方队伍索引
     */
    public TeamIndex getReceiverIndex(TeamIndex index) {
        switch (this) {
            case ATTACK:
                return index.getOpponentIndex();
            case HEAL:
            default:
                return index;
        }
    }
}
