package com.SOEN6441.Lab5;

import java.util.function.Function;
import java.util.stream.*;

public class ParallelStreams {

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }
    
    public static long sequentialSum(long n) {
    	return Stream.iterate(1L, i ->i+1)
    				 .limit(n)
    				 .reduce(Long::sum)
    				 .get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }


    public static long measurePerformance(Function <Long, Long> adder, long n ) {
    	
    	long fastest = Long.MAX_VALUE;
    	
    	for(int i=0; i<10; i++) {
    		long startTime = System.nanoTime();
        	long sum = adder.apply(n);
        	long duration = (System.nanoTime() - startTime) /1_000_000;
        	
        	if (duration < fastest)
        		fastest = duration;
    	}
    	
    	return fastest;
  
    }
  
    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
    
    //code written by me
    public static void main(String [] args) {
    	System.out.println("Iterative sum done in "
    			+ measurePerformance(ParallelStreams::iterativeSum, 10_000_000)
    			+ "ms" );
    	
    	System.out.println("Sequential sum done in: "
    			+ measurePerformance(ParallelStreams::sequentialSum, 10_000_000)
    			+ " ms");
    	
    	System.out.println("Parallel sum done in: "
    			+ measurePerformance(ParallelStreams::parallelSum, 10_000_000)
    			+ " ms");
    	
    	System.out.println("ranged sum done in: "
    			+ measurePerformance(ParallelStreams::rangedSum, 10_000_000)
    			+ " ms");
    	
    	System.out.println("parallel ranged sum done in: "
    			+ measurePerformance(ParallelStreams::parallelRangedSum, 10_000_000)
    			+ " ms");
    	
    	System.out.println("side effect sum done in: "
    			+ measurePerformance(ParallelStreams::sideEffectSum, 10_000_000)
    			+ " ms");
    	
    	System.out.println("side effects parallel ranged sum done in: "
    			+ measurePerformance(ParallelStreams::sideEffectParallelSum, 10_000_000)
    			+ " ms");
    	
    	
    	
    	
    }
}
