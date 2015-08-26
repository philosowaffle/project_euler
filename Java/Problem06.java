/**
 * Project Euler - Problem 6
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + .... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + .... + 10)^2 = 3025
 * Hence the difference between the sum of the squares of the first ten
 * natural numbers and the square of the sum is 3025-385 = 2640.
 * Find the difference between the the sum of the squares of the first
 * one hundred natural numbers and the square of the sum.
 *
 * @author Bailey Belvis
 */
public class Problem6
{
	private final static int solution = 25164150;

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
		int sumOfSquares = 0;
		int squareOfSums = 0;

		for (int x = 1; x <= 100; x++) {
			sumOfSquares += (x * x);
			squareOfSums += x;
		}

		squareOfSums = squareOfSums * squareOfSums;

		answer = squareOfSums - sumOfSquares;

		print(answer);

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
