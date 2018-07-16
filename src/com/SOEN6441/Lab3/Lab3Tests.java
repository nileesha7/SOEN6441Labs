package com.SOEN6441.Lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.SOEN6441.Lab3.FilteringApples.Apple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

class Lab3Tests {
	
	static List<Apple> inventory;

	@BeforeAll
	static void initAll() {
		inventory = Arrays.asList(new Apple(80,"green"), 
								  new Apple(155, "green"), 
								  new Apple(120, "red"));	
	}
	
	@Test
	void testFilterGreenApples() {
		List<Apple> expected = Arrays.asList(new Apple(80,"green"), 
				  							new Apple(155, "green"));
		List <Apple> actual = FilteringApples.filterGreenApples(inventory);
		
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	void testFilterApplesByColor() {
		List<Apple> expected = Arrays.asList(new Apple(120,"red"));
		List <Apple> actual = FilteringApples.filterApplesByColor(inventory, "red");

		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	void testFilterApplesByWeight() {
		List<Apple> expected = Arrays.asList(new Apple(155, "green"));
		List <Apple> actual = FilteringApples.filterApplesByWeight(inventory, 150);

		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	void testFilterApples() {
		List<Apple> expected = Arrays.asList(new Apple(80, "green"),
											 new Apple(155, "green"));
		List <Apple> actual = FilteringApples.filter(inventory, (Apple a) -> a.getColor().equals("green"));

		assertThat(actual, is(equalTo(expected)));
	}
	
	
}
