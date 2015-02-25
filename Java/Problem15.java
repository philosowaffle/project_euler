package CTGApp.handlers;

import java.math.BigInteger;

/**
 * Project Euler - Problem 15
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 *
 * @author Bailey Belvis
 */
public class Problem15
{
	private final static BigInteger solution = new BigInteger("137846528820"); //$NON-NLS-1$

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
	 * http://joaoff.com/2008/01/20/a-square-grid-path-problem/
	 */
	static void solutionOne()
	{
		BigInteger answer = new BigInteger("0"); //$NON-NLS-1$
		final BigInteger size = new BigInteger("20"); //$NON-NLS-1$

		final BigInteger top = factorial(size.multiply(new BigInteger("2"))); //$NON-NLS-1$
		final BigInteger bottom = factorial(size).multiply(factorial(size));

		answer = top.divide(bottom);

		print(answer);

	}

	/**
	 * Calculates the factorial of a given number.
	 *
	 * @param x
	 *        the number to calculate (x!)
	 * @return the factorial
	 */
	static BigInteger factorial(final BigInteger x)
	{
		final BigInteger one = new BigInteger("1"); //$NON-NLS-1$

		// if x > 1
		if (x.compareTo(one) == 1) {

			BigInteger fac = x;

			fac = fac.multiply(factorial(fac.subtract(one)));

			return fac;
		}

		return one;

	}

	/**
	 * Prints a value.
	 *
	 * @param value
	 *        int
	 */
	static void print(final BigInteger value)
	{
		if (value.compareTo(solution) == 0) {
			System.out.println("Correct: " + value); //$NON-NLS-1$
		}
		else {
			System.out.println("Incorrect: " + value); //$NON-NLS-1$
		}

	}

}
