package co.com.mercadolibre.MELIChallenge.enums;

public enum DnaType {
    HUMAN(0L),
    MUTANT(1L);


    private Long type;

    private DnaType(Long type){
        this.type = type;
    }

    public Long getType() {
        return type;
    }

}
