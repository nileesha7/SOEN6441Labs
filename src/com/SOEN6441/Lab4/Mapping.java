package com.SOEN6441.Lab4;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Mapping {

	public static void main(String[] args) {
		
		System.out.println("1) Squares");

		//Given a list of numbers, return a list of the square of each number
		List <Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List <Integer> squares = numbers.stream()
								.map(number->number*number)
								.collect(toList());
		System.out.println(squares);

		System.out.println("-----");

		
		
		//Given two lists of numbers, return all pairs of numbers
		System.out.println("1) Pairs");
		List <Integer> list1 = Arrays.asList(1,2,3);
		List <Integer> list2 = Arrays.asList(3,4);

		List<Integer[]> pairs = list1.stream()
							  .flatMap(i->list2.stream().map(j->new Integer[] {i,j}))
							  .collect(toList());
		pairs.forEach(pair-> System.out.println("["+pair[0]+", "+pair[1]+"]"));

		System.out.println("-----");
		
		

		
		
		//Extend the previous example to return only pairs whose sum is divisible by 3: For example, (2, 4) and (3, 3) are valid.
		System.out.println("1) Pairs whose sum is divisible by 3");
		List <Integer[]> pairsDivisibleBy3 = list1.stream()
					.flatMap(i->list2.stream()
							.map(j->new Integer[] {i,j})
							.filter(pair -> (pair[0]+pair[1])%3 == 0))
					.collect(toList());
		
		pairsDivisibleBy3.forEach(pair-> System.out.println("["+pair[0]+", "+pair[1]+"]"));
	}

}
