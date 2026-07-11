package battles;

public enum TeamIndex {
    TEAMA, TEAMB;

    /**
     * 获取对手的队伍索引
     *
     * @return TEAMA返回TEAMB,TEAMB返回TEAMA
     */
    public TeamIndex getOpponentIndex() {
        return this == TEAMA ? TEAMB : TEAMA;
    }
}
