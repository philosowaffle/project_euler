/**
 * Project Euler - Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 and 5,
 * we get 3, 5, 6, and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author Bailey Belvis
 */
public class Problem1
{
	private final static int solution = 233168;

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

		// Solution 2
		solutionTwo();
	}

	/**
	 * Loop from 0 to 1000 and check every number.
	 */
	static void solutionOne()
	{
		int answer = 0;

		for (int x = answer; x < 1000; x++) {
			if (((x % 3) == 0) || ((x % 5) == 0)) {
				answer += x;
			}
		}

		print(answer);
	}

	/**
	 * Loop from 999 to 0 and check every number.
	 */
	static void solutionTwo()
	{
		int answer = 0;

		for (int x = 999; x >= 0; x--) {
			if (((x % 3) == 0) || ((x % 5) == 0)) {
				answer += x;
			}
		}

		print(answer);
	}

	/**
	 * Prints a value.
	 *
	 * @param value
	 *        int
	 */
	static void print(final int value)
	{
		if (value == solution) {
			System.out.println("Correct: " + value); //$NON-NLS-1$
		}
		else {
			System.out.println("Incorrect: " + value); //$NON-NLS-1$
		}

	}

}
