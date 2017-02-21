package matrixReduc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatrixTester {
	double[][] matrix =
				{{2, 4, 8},
				{3, 6, 9}};
	double[][] matrix2 = 
				{{1, -2, 1, 0},
				{0, 2, -8, 8},
				{5, 0, -5, 10}};
	double[][] matrix3 = 
				{{1, 2, 7},
				{-2, 5, 4},
				{-5, 6, 3}};
	Matrix m;
	Matrix m2;
	Matrix m3;
	
	@Before
	public void setup() {
		m = new Matrix(matrix);
		m2 = new Matrix(matrix2);
		m3 = new Matrix(matrix3);
	}

	@Test
	public void replacementTest() {
		m.replacement(4, 0, 1);
		System.out.println("REPLACEMENT");
		System.out.println(m.toString());
	}
	
	@Test
	public void scaleTest() {
		m.scale(2, 0);
		System.out.println("SCALE");
		System.out.println(m.toString());
	}
	
	@Test
	public void interchangeTest() {
		m.interchange(0, 1);
		System.out.println("INTERCHANGE");
		System.out.println(m.toString());
	}
	
	@Test
	public void simplifyReplaceTest() {
		m.simplify();
		System.out.println("SIMPLIFY REPLACE");
		System.out.println(m.toString());
	}
	
	@Test
	public void simplifyReplaceTest2() {
		m2.simplify();
		System.out.println("SIMPLIFY REPLACE 2");
		System.out.println(m2.toString());
	}
	
	@Test
	public void simplifyReplaceTest3() {
		m3.simplify();
		System.out.println("SIMPLIFY REPLACE 3");
		System.out.println(m3.toString());
	}

}
