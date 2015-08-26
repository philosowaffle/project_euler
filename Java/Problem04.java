/**
 * Project Euler - Problem 4
 * A palindromic number reads the same both ways. The largest palindrome
 * made from the product of two 2-digit numbers is 9009 = 91 x 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author Bailey Belvis
 */
public class Problem4
{
	private final static int solution = 906609;

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
	 */
	static void solutionOne()
	{
		long answer = 0;

		for (int x = 999; x > 99; x--) {
			for (int y = x; y > 99; y--) {
				System.out.println(x + " * " + y + " = " + (y * x)); //$NON-NLS-1$ //$NON-NLS-2$
				if (isPalindrome(y * x) && ((y * x) > answer)) {
					answer = y * x;
					break;
				}
			}
		}

		print(answer);

	}

	/**
	 * Determines if an integer value is a palindrome
	 *
	 * @param value
	 *        int
	 * @return true if the value is a palindrome
	 */
	static boolean isPalindrome(final int value)
	{
		final String numberString = value + ""; //$NON-NLS-1$
		final int size = numberString.length();
		int forward = 0;
		int backwards = size - 1;

		for (int x = forward; x < size; x++) {
			if (numberString.charAt(forward) != (numberString.charAt(backwards))) {
				return false;
			}

			forward++;
			backwards--;
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
