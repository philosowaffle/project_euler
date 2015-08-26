/**
 * Project Euler - Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * @author Bailey Belvis
 */
public class Problem9
{
	private final static long solution = 31875000;

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

		int a = 1;
		int b = 2;
		int c = 3;

		for (a = 1; a <= 997; a++) {
			for (b = a + 1; b <= (1000 - a); b++) {
				for (c = b + 1; c <= (1000 - a - b); c++) {
					// if pythagorean triplet
					if (((a * a) + (b * b)) == (c * c)) {
						// if sum == 1000
						if ((a + b + c) == 1000) {
							answer = a * b * c;
							break;
						}
					}

					if (answer != 0) {
						break;
					}
				}

				if (answer != 0) {
					break;
				}
			}

			if (answer != 0) {
				break;
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
