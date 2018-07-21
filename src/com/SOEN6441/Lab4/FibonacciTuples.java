package com.SOEN6441.Lab4;

import java.util.stream.Stream;

public class FibonacciTuples {

	public static void main(String[] args) {
		/*
		 * The Fibonacci series is famous as a classic programming exercise. The numbers in the following sequence are part of the Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.... The first two numbers of the series are 0 and 1, and each subsequent number is the sum of the previous two.
		   The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in the series: (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)....
		   Your task is to generate the first 20 elements of the series of Fibonacci tuples using the iterate method!
		 */
		Stream.iterate(new int[] {0,1}, tuple->new int[] {tuple[1], tuple[0]+tuple[1]})
			  .limit(20)
			  .forEach(tuple -> System.out.println("("+ tuple[0] + ", "+tuple[1]+")"));
	}

}
