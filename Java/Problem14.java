package CTGApp.handlers;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Euler - Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
 * that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * @author Bailey Belvis
 */
public class Problem14
{
	private final static long solution = 837799;

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
		final List<Long> chain = new ArrayList<>();

		for (int x = 1; x < 1000000; x++) {
			final List<Long> tempChain = collatzChain(x);

			if (tempChain.size() > chain.size()) {
				chain.clear();
				chain.addAll(tempChain);
				answer = x;
			}

		}

		print(answer);

	}

	/**
	 * Generates a Collatz Chain for a given start value.
	 *
	 * @param startValue
	 *        long
	 * @return List<Long> collatzChain
	 */
	static List<Long> collatzChain(final long startValue)
	{
		long chainItem = startValue;
		final List<Long> chainItems = new ArrayList<>();

		while (chainItem > 1) {

			if ((chainItem % 2) == 0) {
				chainItem = chainItem / 2;
			}
			else {
				chainItem = (3 * chainItem) + 1;
			}

			chainItems.add(chainItem);
		}

		return chainItems;
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
