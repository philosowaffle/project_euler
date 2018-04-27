using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using FluentAssertions;
using NUnit.Framework;

namespace ProjectEulerProblems
{
	/// <summary>
	/// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	/// Find the sum of all the multiples of 3 or 5 below 1000.
	/// </summary>
	public class Problem01 : BaseTest
	{
		private const int Solution = 233168;
		private const int MaxValue = 1000;
		private const int Divisor01 = 3;
		private const int Divisor02 = 5;

		[Test]
		public void Solution01()
		{
			var answer = 0;
			var values = new List<int>();

			for (var x = 0; x < MaxValue; x++)
			{
				if(x % Divisor01 == 0 || x % Divisor02 == 0)
					values.Add(x);
			}

			answer = values.Sum();
			answer.Should().Be(Solution);
		}

		[Test]
		public void Solution02()
		{
			var answer = 0;

			for (var x = 0; x < MaxValue; x++)
			{
				if (x % Divisor01 == 0 || x % Divisor02 == 0)
					answer += x;
			}

			answer.Should().Be(Solution);
		}

		[Test]
		public void Solution03()
		{
			var answer = 0;

			var counter = 0;
			while (counter < MaxValue)
			{
				if (counter % Divisor01 == 0 || counter % Divisor02 == 0)
					answer += counter;

				counter++;
			}

			answer.Should().Be(Solution);
		}

		[Test]
		public void Solution04()
		{
			var answer = 0;
			
			answer = Solution04_SumOfDivisibleBy(Divisor01, answer, MaxValue);
			answer = Solution04_SumOfDivisibleBy(Divisor02, answer, MaxValue);

			var fifteenSum = Solution04_SumOfDivisibleBy(Divisor01 * Divisor02, 0, MaxValue);
			answer = answer - fifteenSum;

			answer.Should().Be(Solution);
		}

		private int Solution04_SumOfDivisibleBy(int divisor, int sum, int maxValue)
		{
			var counter = 0;
			while (counter < maxValue)
			{
				if (counter % divisor == 0)
					sum += counter;
				counter += divisor;
			}

			return sum;
		}

		[Test]
		public void Solution05()
		{
			var answer = 0;

			var a1 = Solution05_SumOfDivisibleBy(Divisor01, 0, MaxValue);
			var a2 = Solution05_SumOfDivisibleBy(Divisor02, 0, MaxValue);

			var fifteenSum = Solution05_SumOfDivisibleBy(Divisor01 * Divisor02, 0, MaxValue);
			answer = a1 + a2 - fifteenSum;

			answer.Should().Be(Solution);
		}

		private int Solution05_SumOfDivisibleBy(int divisor, int sum, int maxValue)
		{
			var counter = 0;
			while (counter < maxValue)
			{
				if (counter % divisor == 0)
					sum += counter;
				counter += divisor;
			}

			return sum;
		}

		[Test]
		public async Task Solution06()
		{
			var answer = 0;

			var counterTask01 = Solution06_SumOfDivisibleBy(Divisor01, 0, MaxValue);
			var counterTask02 = Solution06_SumOfDivisibleBy(Divisor02, 0, MaxValue);
			var counterTask03 = Solution06_SumOfDivisibleBy(Divisor01 * Divisor02, 0, MaxValue);

			await Task.WhenAll(counterTask01, counterTask02, counterTask03);

			answer = (await counterTask01) + (await counterTask02) - (await counterTask03);

			answer.Should().Be(Solution);
		}

		private async Task<int> Solution06_SumOfDivisibleBy(int divisor, int sum, int maxValue)
		{
			await Task.Run(() =>
			{
				var counter = 0;
				while (counter < maxValue)
				{
					if (counter % divisor == 0)
						sum += counter;
					counter += divisor;
				}
			});

			return sum;
		}
	}
}
