package streamreduce;

import java.util.*;
import java.util.stream.IntStream;

public class ReduceEx {
    public static void main(String[] args){

        //Sum of all elements using reduce()
        List<Integer> list = Arrays.asList(12,14,54,67,14,178,96);
        int result = list.stream().reduce(0, (a, b)->a+b);
        System.out.println(result);

        //Maximum using reduce()
        int result1 = list.stream().reduce(0,(a,b) -> a>b ? a: b) ;
        System.out.println(result1);

        //Minimum using reduce()
        int result2 = list.stream().reduce(Integer.MAX_VALUE, (a,b) -> a<b ? a :b);
        System.out.println(result2);

        //count using reduce()
        int result3 = list.stream().reduce(0, (a, b)-> a+1);
        System.out.println(result3);

        //Sum of even numbers
        int result4 = list.stream().reduce(0, (a,b) -> b%2 ==0 ? a+b : b);
        System.out.println(result4);

        //Convert list into single string
        List<String> list1 = Arrays.asList("Java", "Stream", "API", "Reduce");
        String concat = list1.stream().reduce("", (a, b) -> a+ b+ " ");
        System.out.println(concat);

        //Sum of squares
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int squaredSum = numbers.stream().reduce(0, (a,b)-> b*b +a);
        System.out.println(squaredSum);

        //Second highest
        int firstHighest = list.stream().reduce(1, (a,b)-> a>b ? a: b);
        int secondHighest = list.stream().reduce(1, (a, b) -> a>b && a<firstHighest ? a : b);
        System.out.println(secondHighest);

        //find the longest string using reduce()
        String longest = list1.stream().reduce("", (a,b) -> a.length()>b.length() ? a : b);
        System.out.println(longest);

        //find average
        int result5 = list.stream().reduce(0, (a,b) -> (a+b))/list.size();
        System.out.println(result5);

        //find factorial using reduce()
        int n = 5;
        int fact = IntStream.rangeClosed(1, n).reduce(1, (a,b) -> a*b);
        System.out.println(fact);
    }
    
}
