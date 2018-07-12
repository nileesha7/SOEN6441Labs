package com.SOEN6441.Lab.Tests;

import com.SOEN6441.Lab.Main.FilteringApples.Apple;
import com.SOEN6441.Lab.Main.FilteringApples;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FilteringApplesTest {
	
	static List <Apple> inventory;
	
	@BeforeAll
	static void setup() {
		inventory = Arrays.asList(new Apple(80,"green"),
                                  new Apple(155, "green"),
                                  new Apple(120, "red"));
	}
	
	@Test
	void testFilterGreenApples() {
		List <Apple> actual = FilteringApples.filterGreenApples(inventory);
		List <Apple> expected = Arrays.asList(new Apple(80,"green"),
                				new Apple(155, "green"));
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	void testFilterHeavyApples() {
		List <Apple> actual = FilteringApples.filterHeavyApples(inventory);
		List <Apple> expected =  Arrays.asList(new Apple(155, "green"));
		
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	void testIsGreenApple() {
		Apple apple = new Apple (100, "green");
		assertThat(FilteringApples.isGreenApple(apple), is(true));
	}
	
	@Test
	void testIsHeavyApple() {
		Apple apple = new Apple (190, "green");
		assertThat(FilteringApples.isHeavyApple(apple), is(true));
		
		apple = new Apple (149, "green");
		assertThat(FilteringApples.isHeavyApple(apple), is(false));
	}
	
	@Test
	void testFilterApples() {
		List <Apple> lightApples = Arrays.asList(new Apple(80, "green"), new Apple(120, "red"));
		List <Apple> actual = FilteringApples.filterApples(inventory, (Apple a)->a.getWeight()<150);
		
		assertThat(actual, is(equalTo(lightApples)));
	}
	
	
}
