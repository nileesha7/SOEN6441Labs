package com.SOEN6441.Lab4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;


public class PuttingIntoPractice {
	
	public static void main(String [] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
		
		List <Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		
		//Find all transactions in the year 2011 and sort them by value (small to high).
		List <Transaction> transactionsIn2011 = transactions.stream()
												.filter(transaction -> transaction.getYear() == 2011)
												.sorted(comparing(Transaction::getValue))
												.collect(toList());
		System.out.println(transactionsIn2011);
		
		//What are all the unique cities where the traders work?
		List<String> uniqueCities = transactions.stream()
									.map(t->t.getTrader().getCity())
									.distinct()
									.collect(toList());
		System.out.println(uniqueCities);
		
		//Find all traders from Cambridge and sort them by name.
		List <Trader> cambrideTraders = transactions.stream()
										.map(transaction->transaction.getTrader())
										.filter(trader -> trader.getCity().equals("Cambridge"))
										.distinct()
										.sorted(comparing(Trader::getName))
										.collect(toList());
		System.out.println(cambrideTraders);
		
		//Return a string of all traders’ names sorted alphabetically.
		String traderNames = transactions.stream()
							 .map(t -> t.getTrader().getName())
							 .distinct()
							 .sorted()
							 .reduce("", (n1, n2)-> n1 +" "+n2);
		System.out.println(traderNames);
		
		//Are any traders based in Milan?
		boolean tradersInMilan = transactions.stream()
										   .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(tradersInMilan);
										  
		//Print all transactions’ values from the traders living in Cambridge.
		transactions.stream()
					.filter(t -> t.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue)
					.forEach(System.out::println);
		 
		//What's the highest value of all the transactions?
		int highestValue = transactions.stream()
						 .map(Transaction::getValue)
						 .reduce(0, Integer::max);
		System.out.println(highestValue);
		
		//Find the transaction with the smallest value.
		Optional <Transaction> smallest = transactions.stream()
							  .min(comparing(Transaction::getValue));
		System.out.println(smallest);
		
		//For each trader, return the number of lowercase letters in the name (hint: look at the chars method on String)
					traders.stream()
				    .map(trader -> trader.getName())
				    .distinct()
				    .map(name -> name.chars().count())
				    .forEach(System.out::println);
		
		//Find the city String with the largest number of lowercase letters from all the cities in the transaction list. Experiment with returning an Optional<String> to account for the case of an empty input list.
	}
}
