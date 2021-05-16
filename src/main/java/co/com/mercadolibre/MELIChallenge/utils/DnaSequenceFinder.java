package co.com.mercadolibre.MELIChallenge.utils;

import co.com.mercadolibre.MELIChallenge.enums.MinSequenceLength;


public class DnaSequenceFinder {

    private char[][] dnaMatrix;

    public DnaSequenceFinder(char[][] dnaMatrix){
        this.dnaMatrix = dnaMatrix;
    }

    /**
     *
     * @return a boolean indicating that there are more than 1 sequences (of length 4 for the same nitrogen base) in the whole matrix
     *
     * if we found more than one sequence in the matrix it means that the dna provided it's from a mutant
     */
    public boolean validateIfIsMutant(){
        int sequencesFound = 0;
        boolean isMutant = false;
        for (int i = 0; i <= dnaMatrix.length - 1; i++) {
            for (int j = 0; j <= dnaMatrix.length - 1; j++) {
                isMutant = sequencesFound >= 2;
                if(isMutant) { break; }
                sequencesFound = validateSequence(i, j, sequencesFound);
            }
        }
        return  isMutant;

    }

    /**
     *
     * @param row
     * @param column
     * @param sequencesFound
     * @return the total number of sequences found in the dna matrix
     *
     * For a (i, j) position in the provided matrix the algorithm will
     * perform validations in four ways:
     *
     * 1. Horizontal
     * 2. Vertical
     * 3. In the Diagonal to the Right
     * 4. In the Diagonal to the Left
     */
    private int validateSequence(int row, int column, int sequencesFound) {

        if(searchHorizontal(row, column, 0)) { sequencesFound++; }
        if(searchVertical(row, column, 0)) { sequencesFound++; }
        if(searchRightDiagonal(row, column, 0)) { sequencesFound++; }
        if(searchLeftDiagonal(row, column, 0)) { sequencesFound++; }

        return sequencesFound;
    }

    /**
     *
     * @param row
     * @param column
     * @param counter
     * @return a boolean that will provided a flag if a sequence of length 4 of the same nitrogen base is present in the right diagonal
     */
    private boolean searchRightDiagonal(int row, int column, int counter) {
        if(counter == MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return true; } else
        if(column >= dnaMatrix.length - MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength() || row >= dnaMatrix.length - MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return false; }
        if(dnaMatrix[row][column] == dnaMatrix[row + 1][column + 1]) {
            row++;
            column++;
            counter++;
            return searchRightDiagonal(row, column, counter);
        }
        return false;
    }

    /**
     *
     * @param row
     * @param column
     * @param counter
     * @return a boolean that will provided a flag if a sequence of length 4 of the same nitrogen base is present in the left diagonal
     */
    private boolean searchLeftDiagonal(int row, int column, int counter) {
        if(counter == MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return true; } else
        if(column < MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength() || row >= dnaMatrix.length - MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()){ return false; }

        if(dnaMatrix[row][column] == dnaMatrix[row + 1][column - 1]) {
            row++;
            column--;
            counter++;
            return searchLeftDiagonal(row, column, counter);
        }
        return false;
    }

    /**
     *
     * @param row
     * @param column
     * @param counter
     * @return a boolean that will provided a flag if a sequence of length 4 of the same nitrogen base is present in the horizontal way
     */
    private boolean searchHorizontal(int row, int column, int counter) {
        if(counter == MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return true; } else
        if(column >= dnaMatrix.length - MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return false; }
        if(dnaMatrix[row][column] == dnaMatrix[row][column + 1]) {
            column++;
            counter++;
            return searchHorizontal(row, column, counter);
        }
        return false;
    }

    /**
     *
     * @param row
     * @param column
     * @param counter
     * @return a boolean that will provided a flag if a sequence of length 4 of the same nitrogen base is present in the vertical way
     */
    private boolean searchVertical(int row, int column, int counter) {
        if(counter == MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return true; } else
        if(row >= dnaMatrix.length - MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength()) { return false; }
        if(dnaMatrix[row][column] == dnaMatrix[row + 1][column]) {
            row++;
            counter++;
            return searchVertical(row, column, counter);
        }
        return false;
    }
}
