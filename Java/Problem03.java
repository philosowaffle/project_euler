/**
 * Project Euler - Problem 3
 * The prime factors of 13195 are 5, 7, 13, 29.
 * What is the largest prime factor of the number 600851475143?
 *
 * @author Bailey Belvis
 */
public class Problem3
{
	private final static int solution = 6857;

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
	 * - We only need to check values 3 -> (value / 2)
	 * - If the the number evenly divides value then check if it is prime
	 */
	static void solutionOne()
	{
		final long value = 600851475143L;
		long check = 0;
		long answer = 0;

		if (isPrime(value)) {
			answer = value;
		}
		else {
			// Start with 3 because it is our first prime number
			// where value / 3 could potentially yield a prime number.
			// (value / 2 will never be prime).
			for (long x = 3; x < (600851475143L / 2); x++) {
				check = value / x;

				if (((value % check) == 0) && isPrime(check)) {
					answer = check;
					break;
				}
			}
		}

		print(answer);

	}

	/**
	 * - We only need to check divisors 3 -> (value / 3);
	 */
	static void solutionTwo()
	{
		final long value = 600851475143L;
		final long boundary = 600851475143L / 3;
		long check = 0;
		long answer = 0;

		if (isPrime(value)) {
			answer = value;
		}
		else {
			// Start with 3 because it is our first prime number
			// where (value / 3) could potentially yield a prime number.
			// (value / 2 will never be prime).
			for (long divisor = 3; divisor < boundary; divisor++) {
				check = value / divisor;

				final long temp = value % check;

				// Is it a factor? Skip even's they are never prime, Is it Prime?
				if ((temp == 0) && isPrime(check)) {
					answer = check;
					break;
				}
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
