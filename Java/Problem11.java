/**
 * Project Euler - Problem 11
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 * 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 * 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 * 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 * 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 * 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 * 32 98 81 28 64 23 67 10 **26** 38 40 67 59 54 70 66 18 38 64 70
 * 67 26 20 68 02 62 12 20 95 **63** 94 39 63 08 40 91 66 49 94 21
 * 24 55 58 05 66 73 99 26 97 17 **78** 78 96 83 14 88 34 89 63 72
 * 21 36 23 09 75 00 76 44 20 45 35 **14** 00 61 33 97 34 31 33 95
 * 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 * 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 * 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 * 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 * 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 * 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 * 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 * 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
 *
 * @author Bailey Belvis
 */
public class Problem11
{
	private final static long solution = 70600674L;

	/**
	 * Main
	 *
	 * @param args
	 *        arg!
	 */
	public static void main(final String[] args)
	{
		// Solution 1
		solutionOne();
	}

	/**
	 *
	 */
	static void solutionOne()
	{
		long answer = 0;
		final int[][] digits = prepareData();

		answer = calculateDown(digits, 4);
		final long right = calculateLargestRight(digits, 4);
		final long diagonalRightDown = calculateLargestDiagRight(digits, 4);
		final long diagonalLeftDown = calculateLargestDiagLeft(digits, 4);

		if (answer < right) {
			answer = right;
		}

		if (answer < diagonalRightDown) {
			answer = diagonalRightDown;
		}

		if (answer < diagonalLeftDown) {
			answer = diagonalLeftDown;
		}

		print(answer);

	}

	/**
	 * Calculates the largest product of sequenceSize consecutive
	 * numbers moving from left to right.
	 *
	 * @param data
	 *        the data matrix to parse
	 * @param sequenceSize
	 *        the number of consecutive digits to multiply
	 * @return the largest product
	 */
	static long calculateLargestRight(final int[][] data, final int sequenceSize)
	{
		long largest = 0;
		final int seqSize = sequenceSize;

		final int columns = data[0].length - sequenceSize;
		final int rows = data.length - sequenceSize;

		if (rows != columns) {
			return -1;
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				long product = 1;
				for (int seq = 0; seq < seqSize; seq++) {
					if ((c + seq) < columns) {
						product *= data[r][c + seq];
					}
				}

				if (product > largest) {
					largest = product;
				}
			}

		}

		return largest;
	}

	/**
	 * Calculates the largest product of sequenceSize consecutive
	 * numbers moving from a starting position diagonally down
	 * towards the right.
	 *
	 * @param data
	 *        the data to parse
	 * @param sequenceSize
	 *        the number of consecutive digits to multiply
	 * @return the largest product
	 */
	static long calculateLargestDiagRight(final int[][] data, final int sequenceSize)
	{
		long largest = 0;
		final int seqSize = sequenceSize;

		final int columns = data[0].length - sequenceSize;
		final int rows = data.length - sequenceSize;

		if (rows != columns) {
			return -1;
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				long product = 1;

				for (int seq = 0; seq < seqSize; seq++) {
					if (((c + seq) < columns) && ((r + seq) < rows)) {
						product *= data[r + seq][c + seq];
					}
				}

				if (product > largest) {
					largest = product;
				}
			}

		}

		return largest;
	}

	/**
	 * Calculates the largest product of sequenceSize consecutive
	 * numbers moving from a starting position diagonally down
	 * towards the right.
	 *
	 * @param data
	 *        the data to parse
	 * @param sequenceSize
	 *        the number of consecutive digits to multiply
	 * @return the largest product
	 */
	static long calculateLargestDiagLeft(final int[][] data, final int sequenceSize)
	{
		long largest = 0;
		final int seqSize = sequenceSize;

		final int columns = data[0].length - seqSize;
		final int rows = data.length - seqSize;

		if (rows != columns) {
			return -1;
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				long product = 1;

				for (int seq = 0; seq < seqSize; seq++) {
					if (((c - seq) >= 0) && ((r + seq) < rows)) {
						product *= data[r + seq][c - seq];
					}
				}
				if (product > largest) {
					largest = product;
				}
			}

		}

		return largest;
	}

	/**
	 * Calculates the largest product of sequenceSize consecutive
	 * numbers moving from a starting position straight down.
	 *
	 * @param data
	 *        the data to parse
	 * @param sequenceSize
	 *        the number of consecutive digits to multiply
	 * @return the largest product
	 */
	static long calculateDown(final int[][] data, final int sequenceSize)
	{
		long largest = 0;
		final int seqSize = sequenceSize;

		final int columns = data[0].length - seqSize;
		final int rows = data.length - seqSize;

		if (rows != columns) {
			return -1;
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				long product = 1;

				for (int seq = 0; seq < seqSize; seq++) {
					if ((r + seq) < rows) {
						product *= data[r + seq][c];
					}
				}

				if (product > largest) {
					largest = product;
				}
			}

		}

		return largest;
	}

	/**
	 * Puts a string of two-digit data into a 20x20 matrix.
	 *
	 * @return int matrix 20x20
	 */
	static int[][] prepareData()
	{
		final String digits = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08" + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00"
			+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65" + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91"
			+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80" + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50"
			+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70" + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21"
			+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72" + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95"
			+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92" + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57"
			+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58" + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40"
			+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66" + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69"
			+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36" + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16"
			+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54" + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

		final int[][] data = new int[20][20];
		int counter = 0;

		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				final int tens = Character.getNumericValue(digits.charAt(counter));
				counter++;
				final int ones = Character.getNumericValue(digits.charAt(counter));
				data[x][y] = (tens * 10) + ones;
				counter += 2;
			}
			counter--;
		}

		return data;
	}

	/**
	 * Prints a value.
	 *
	 * @param value
	 *        int
	 */
	static void print(final long value)
	{
		if (value == solution) {
			System.out.println("Correct: " + value); //$NON-NLS-1$
		}
		else {
			System.out.println("Incorrect: " + value); //$NON-NLS-1$
		}

	}

}
