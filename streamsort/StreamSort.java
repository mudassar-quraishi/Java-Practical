//package streamsort;
import java.util.*;

public class StreamSort {
    public static void main(String[] args){
        //Sort the list
        List<Integer> list = Arrays.asList(12,14,54,67,14,178,96);
        List<Integer> result = list.stream().sorted().toList();
        System.out.println(result);

        //Reverse order
        List<Integer> result1 = list.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> result2 = list.stream().sorted((a,b)-> b-a).toList();
        System.out.println(result1);
    }
    
}
