/**
 * Project Euler - Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with British usage.
 *
 * @author Bailey Belvis
 */
public class Problem17
{
	private final static long solution = 21124;

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

		for (int x = 0; x <= 1000; x++) {
			answer += calculateNumberOfLetters(x);
		}

		print(answer);

	}

	/**
	 * Calculate the number of chars in the English representation of any
	 * number between 1 and 1000 inclusive.
	 *
	 * @param numberToCalculate
	 *        int
	 * @return int number of characters
	 */
	static int calculateNumberOfLetters(final int numberToCalculate)
	{
		int numberOfLetters = 0;

		if (numberToCalculate < 10) {

			numberOfLetters = numberOfLettersLessTen(numberToCalculate);

		}
		else if (numberToCalculate < 100) {

			numberOfLetters = numberOfLettersLessHundred(numberToCalculate);

		}
		else if (numberToCalculate < 1000) {

			numberOfLetters = numberOfLettersLessThousand(numberToCalculate);

		}
		else if (numberToCalculate == 1000) {

			// one thousand
			numberOfLetters = 11;

		}

		return numberOfLetters;
	}

	/**
	 * Returns number of letters in the English representation
	 * of a given number less than 10.
	 *
	 * @param x
	 *        the number
	 * @return number of letters
	 */
	static int numberOfLettersLessTen(final int x)
	{
		int numberOfLetters = 0;

		switch (x) {
		case 1: // one
		case 2: // two
		case 6: // six
			numberOfLetters = 3;
			break;
		case 3: // three
		case 7: // seven
		case 8: // eight
			numberOfLetters = 5;
			break;
		case 4: // four
		case 5: // five
		case 9: // nine
			numberOfLetters = 4;
			break;
		default:
			break;

		}

		return numberOfLetters;
	}

	/**
	 * Returns number of letters in the English representation
	 * of a given number less than 100.
	 *
	 * @param x
	 *        the number
	 * @return number of letters
	 */
	static int numberOfLettersLessHundred(final int x)
	{
		int numberOfLetters = 0;

		final int tens = x / 10;
		final int ones = x % 10;

		switch (tens) {
		case 1: // ten
			switch (ones) {
			case 0: // ten
				numberOfLetters = 3;
				break;
			case 1: // eleven
			case 2: // twelve
				numberOfLetters = 6;
				break;
			case 3: // thirteen
			case 4: // fourteen
			case 8: // eighteen
			case 9: // nineteen
				numberOfLetters = 8;
				break;
			case 5: // fifteen
			case 6: // sixteen
				numberOfLetters = 7;
			break;
			case 7: // seventeen
				numberOfLetters = 9;
			break;
			default:
			break;
			}
		break;
		case 4: // forty
		case 5: // fifty
		case 6: // sixty
			numberOfLetters = 5;
			break;
		case 2: // twenty
		case 3: // thirty
		case 8: // eighty
		case 9: // ninety
			numberOfLetters = 6;
		break;
		case 7: // seventy
			numberOfLetters = 7;
		break;
		default:
			break;

		}

		if (x <= 20) {
			return numberOfLetters;
		}

		return numberOfLetters + numberOfLettersLessTen(ones);
	}

	/**
	 * Returns number of letters in the English representation
	 * of a given number less than 1000.
	 *
	 * @param x
	 *        the number
	 * @return number of letters
	 */
	static int numberOfLettersLessThousand(final int x)
	{
		int numberOfLetters = 0;

		final int hundreds = x / 100;
		int tens = (x - (hundreds * 100));

		// [one, two, ...] + hundred
		numberOfLetters = numberOfLettersLessTen(hundreds) + 7;

		if (tens < 10) {

			tens = numberOfLettersLessTen(tens);

		}
		else {

			tens = numberOfLettersLessHundred(tens);
		}

		if (tens > 0) {
			// [one, two, ...] + hundred + and + [twelve, forty-five, fifty-two, ...]
			numberOfLetters = numberOfLetters + 3 + tens;
		}

		return numberOfLetters;
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
