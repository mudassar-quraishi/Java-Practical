//package streamminmax;
import java.util.*;

public class MinMax {
    public static void main(String[] args){

        //find minimum
        List<Integer> list = Arrays.asList(23,12,12,6,6,67,89,43);
        Optional<Integer> min = list.stream().min((a,b)-> a-b);
        min.ifPresent(System.out::println);

        //find maximum
        Optional<Integer> max = list.stream().max((a,b)->b-a);
        max.ifPresent(System.out::println);

        //Remove duplicates
        List<Integer> unique = list.stream().distinct().toList();
        System.out.println(unique);

        //Print first 4 elements
        List<Integer> first4 = list.stream().distinct().limit(4).toList();
        System.out.println(first4);
        
        //Skip first 3 elements
        List<Integer> skip3 = list.stream().skip(3).toList();
        System.out.println(skip3);

    }
    
}
