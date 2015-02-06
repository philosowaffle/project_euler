/**
 * Project Euler - Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * @author Bailey Belvis
 */
public class Problem10
{
	private final static long solution = 142913828922L;

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

		final long cap = 2000000;

		for (long x = 2; x < cap; x++) {
			if (isPrime(x)) {
				answer += x;
			}
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
