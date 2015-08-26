/**
 * Project Euler - Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13
 * we can see that the 6th prime number is 13.
 * What is the 10,001st prime number?
 *
 * @author Bailey Belvis
 */
public class Problem7
{
	private final static int solution = 104743;

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

		int valueToCheck = 2;
		int counter = 0;

		while (counter != 10001) {
			if (isPrime(valueToCheck)) {
				answer = valueToCheck;
				counter++;
			}

			valueToCheck++;
		}

		print(answer);

	}

	/**
	 * Determines if a given number is prime.
	 *
	 * @param value
	 *        the value to check if prime
	 * @return true if the value is prime
	 */
	static boolean isPrime(final long value)
	{
		// 2 is Prime
		if (value == 2) {
			return true;
		}

		// Check if even
		if ((value % 2) == 0) {
			return false;
		}

		final long cap = value / 2;

		// Only need to check odds because all primes
		// are odd
		for (long x = 3; x < cap; x += 2) {
			if ((value % x) == 0) {
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
