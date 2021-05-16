package co.com.mercadolibre.MELIChallenge;

import java.util.ArrayList;
import java.util.List;

public class MainTry {

	public static String[][] matrix = {{"A","T","G","C","G","A"},
										{"C", "A", "G", "T", "G", "C"},
										{"T", "T", "A", "T", "T", "T"},
										{"A", "G", "A", "C", "G", "G"},
										{"G", "C", "G", "T", "C", "A"},
										{"T", "C", "A", "C", "T", "G"}
										};
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*int globalCounter = 0;
		for (int i = 0; i <= matrix.length - 1; i++) {
			for (int j = 0; j <= matrix.length - 1; j++) {
				if(globalCounter >= 2) {
					break;
				}
				globalCounter =
						validateSequence(i, j, globalCounter);
			}
		}
		
		boolean isMutant = globalCounter >= 2;
		System.out.println(isMutant);
*/

		List<String> listOfSequences = new ArrayList<>();
		listOfSequences.add("ATGCGA");
		listOfSequences.add("CAGTGC");
		listOfSequences.add("TTATGT");
		listOfSequences.add("AGAAGG");
		listOfSequences.add("CCCCTA");
		listOfSequences.add("TCACTG");

		String a = listOfSequences.stream().reduce((fullStringSequence, indvidualSequence) -> { return fullStringSequence + indvidualSequence;}).orElseThrow(Exception::new);
		System.out.println(a);
	}
	
	
	
	public static int validateSequence(int row, int column, int globalCounter) {
		
		if(searchHorizontal(row, column, 0)) {
			globalCounter++;
		}
		
		if(searchVertical(row, column, 0)) {
			globalCounter++;
		}
		
		if(searchRightDiagonal(row, column, 0)) {
			globalCounter++;
		}

		if(searchLeftDiagonal(row, column, 0)) {
			globalCounter++;
		}

		return globalCounter;
	}
	
	
	public static boolean searchRightDiagonal(int row, int column, int counter) {
		if(counter == 3) { return true; } else
		if(column >= matrix.length - 3 || row >= matrix.length - 3) { return false; }
		if(matrix[row][column] == matrix[row + 1][column + 1]) {
			row++;
			column++;
			counter++;
			return searchRightDiagonal(row, column, counter);
		}
		return false;
	}
	
	public static boolean searchLeftDiagonal(int row, int column, int counter) {
		if(counter == 3) { return true; } else
		if(column < 3 || row >= matrix.length - 3){ return false; }
		if(matrix[row][column] == matrix[row + 1][column - 1]) {
			row++;
			column--;
			counter++;
			return searchLeftDiagonal(row, column, counter);
		}
		return false;
	}
	
	public static boolean searchHorizontal(int row, int column, int counter) {
		if(counter == 3) { return true; } else
		if(column >= matrix.length - 3) { return false; }
		if(matrix[row][column] == matrix[row][column + 1]) {
			column++;
			counter++;
			return searchHorizontal(row, column, counter);
		}
		return false;
	}
	
	public static boolean searchVertical(int row, int column, int counter) {
		if(counter == 3) { return true; } else
		if(row >= matrix.length - 3) { return false; }
		if(matrix[row][column] == matrix[row + 1][column]) {
			row++;
			counter++;
			return searchVertical(row, column, counter);
		}
		return false;
	}
}
