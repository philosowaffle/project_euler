import java.math.BigInteger;

/**
 * Project Euler - Problem 16
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 *
 * @author Bailey Belvis
 */
public class Problem16
{
	private final static long solution = 1366;

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
	 * Solution One
	 */
	static void solutionOne()
	{
		long answer = 0;

		BigInteger power = new BigInteger("2"); //$NON-NLS-1$
		power = power.pow(1000);

		final String digits = power.toString();

		for (int x = 0; x < digits.length(); x++) {
			answer += Character.digit(digits.charAt(x), 10);
		}

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
