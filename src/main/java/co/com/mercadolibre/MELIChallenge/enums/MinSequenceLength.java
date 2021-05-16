package co.com.mercadolibre.MELIChallenge.enums;

public enum MinSequenceLength {

    MIN_DNA_SEQUENCE_TO_BE_MUTANT(3);


    private int minLength;

    private MinSequenceLength(int minLength){
        this.minLength = minLength;
    }

    public int getMinLength() {
        return minLength;
    }

}
