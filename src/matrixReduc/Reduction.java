package matrixReduc;

public class Reduction {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.exit(1);
		}
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);
		double[][] matrix = new double[rows][columns];
		int count = 2;
		for (int values = 0; values < rows; values++) {
			for (int columnVals = 0; columnVals < columns; columnVals++) {
				matrix[values][columnVals] = Integer.parseInt(args[count]);
				count++;
			}
		}
		Matrix m = new Matrix(matrix);
		m.simplify();
		System.out.println(m.toString());
	}
}
