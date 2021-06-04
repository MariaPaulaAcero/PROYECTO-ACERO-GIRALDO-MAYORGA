package sample.logic.entities;

public enum LeaderTypeEnum {

    CAMPESINO,
    AMBIENTALISTA,
    AFRODESCENDIENTES,
    COMUNAL,
    INDIGENA,
    LGTBIQ,
    SINDICAL,
    CIVICO,
    NO_APLICA
    ;

    public String getCriteria(LeaderTypeEnum leaderTypeEnum) {
        return String.valueOf(leaderTypeEnum);
    }
}
