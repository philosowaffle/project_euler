
using System.Diagnostics;
using FluentAssertions;
using NUnit.Framework;

namespace ProjectEulerProblems
{
	[Parallelizable(ParallelScope.None)]
	public class BaseTest
	{
		private Stopwatch _stopwatch;

		[OneTimeSetUp]
		public void OneTimeSetup()
		{
			_stopwatch = new Stopwatch();
		}

		[SetUp]
		public void Setup()
		{
			_stopwatch.Restart();
		}

		[TearDown]
		public void Teardown()
		{
			TestContext.Out.WriteLine($"{TestContext.CurrentContext.Test.Name} Elapsed: {_stopwatch.ElapsedTicks} ticks");
		}

		[Test]
		[Order(1)]
		public void WarmUp()
		{
			1.Should().Be(1);
		}

		[Test]
		[Order(2)]
		public void Baseline()
		{
			1.Should().Be(1);
		}
	}
}
