
public class Test {

	public static void main(String[] args) {
	// Create Integer arrays m1, m2
    Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
    Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

    Rational[][] m3 = new Rational[3][3];
    Rational[][] m4 = new Rational[3][3];
    
    // Create an instance of IntegerMatrix
    IntegerMatrix integerMatrix = new IntegerMatrix();

    System.out.println("\nm1 + m2 is ");
    GenericMatrix.printResult( m1, m2, integerMatrix.addMatrix(m1, m2), '+');

    System.out.println("\nm1 * m2 is ");
    GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
    
   
    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < m1[0].length; j++) {
        m3[i][j] = new Rational(i + 1, j + 5);
        m4[i][j] = new Rational(i + 1, j + 6);
      }

    // Create an instance of RationalMatrix
    RationalMatrix rationalMatrix = new RationalMatrix();

    System.out.println("\nm3 + m4 is ");
    GenericMatrix.printResult(
      m3, m4, rationalMatrix.addMatrix(m3, m4), '+');

    System.out.println("\nm3 * m4 is ");
    GenericMatrix.printResult(
      m3, m4, rationalMatrix.multiplyMatrix(m3, m4), '*');

	}
}
