/**
 * Project Euler - Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 *
 * @author Bailey Belvis
 */
public class Problem5
{
	private final static int solution = 232792560;

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
	 * We know that 2520 is divisible by all numbers from
	 * 1 to 10 so we can start from there.
	 */
	static void solutionOne()
	{
		long answer = 0;
		int numToCheck = 2520;

		while (answer == 0) {
			if (divisibleOneToTwenty(numToCheck)) {
				answer = numToCheck;
			}
			else {
				// We only need to check multiples of 20 since
				// they are the only numbers evenly divisble
				// by 20
				numToCheck += 20;
			}
		}

		print(answer);

	}

	/**
	 * Determines if a given value is evenly divisible by every
	 * whole integer between 1 and 20.
	 *
	 * @param value
	 *        the value to check
	 * @return true if evenly divisible by all whole integers from 1 to 20
	 */
	static boolean divisibleOneToTwenty(final int value)
	{
		for (int x = 2; x <= 20; x++) {
			if ((value % x) != 0) {
				return false;
			}
		}
		return true;
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
