package battles;

public enum TeamIndex {
    TEAMA, TEAMB;
    public TeamIndex getOpponentIndex(){
        return this == TEAMA?TEAMB:TEAMA;
    }
}
