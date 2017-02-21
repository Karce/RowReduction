package matrixReduc;

public class Matrix {
	private int rows, columns;
	private double[][] matrix;
	
	public Matrix(double[][] matrix) {
		this.rows = matrix.length;
		this.columns = matrix[0].length;
		this.matrix = matrix;
	}
	
	public void scale(double scalar, int row) {
		for (int num = 0; num < matrix[row].length; num++) {
			matrix[row][num] = matrix[row][num] * scalar;
		}
	}
	
	public void replacement(double scalar, int row, int replacedRow) {
		//double[] newRow = copyRow(row);
		for (int num = 0; num < matrix[row].length; num++) {
			matrix[replacedRow][num] = (matrix[row][num] * scalar) - matrix[replacedRow][num];
		}
	}
	
	public void interchange (int row1, int row2) {
		double[] copyOfRow1 = copyRow(row1);
		matrix[row1] = matrix[row2];
		matrix[row2] = copyOfRow1;
	}
	
	public double[] copyRow(int row) {
		int rowLength = matrix[row].length;
		double[] newRow = new double[rowLength];
		for (int num = 0; num < rowLength; num++) {
			newRow[num] = matrix[row][num];
		}
		return newRow;
	}
	
	public void simplify() {
		int least = 0;
		if (rows <= columns - 1) {
			least = rows;
		}
		else {
			least = columns - 1;
		}
		for (int count = 0; count < least; count++) {
			if (matrix[count][count] != 1 && matrix[count][count] != 0) {
				scale(1/matrix[count][count], count);
			}
			if (matrix[count][count] == 1) {
				replaceRows(count, count);
			}
		}
	}
	
	/**
	 * 
	 * @param row - represents the pivot position with a reduced 1 already
	 * @param column
	 */
	public void replaceRows(int row, int column) {
		int rowToReplace = row + 1;
		double scalar;
		if (rowToReplace < rows) {
			for (;rowToReplace < rows; rowToReplace++) {
				if (matrix[rowToReplace][column] == 0) {
					continue;
				}
				scalar = matrix[rowToReplace][column] / matrix[row][column];
				replacement(scalar, row, rowToReplace);
			}
		}
		
		if (row != 0) {
			rowToReplace = row - 1;
			for (;rowToReplace >= 0; rowToReplace--) {
				if (matrix[rowToReplace][column] == 0) {
					continue;
				}
				scalar = matrix[rowToReplace][column] / matrix[row][column];
				replacement(scalar, row, rowToReplace);
			}
		}

	}
	
	public String toString() {
		String matrixString = "";
		for (int values = 0; values < rows; values++) {
			for (int columnVals = 0; columnVals < columns; columnVals++) {
				matrixString += "" + matrix[values][columnVals] + ", ";
			}
			matrixString += "\n";
		}
		return matrixString;
	}
}
