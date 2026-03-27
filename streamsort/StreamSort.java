//package streamsort;
import java.util.*;

public class StreamSort {
    public static void main(String[] args){
        //Sort the list
        List<Integer> list = Arrays.asList(12,14,13,85,13,17,19,21,63);
        List<Integer> result = list.stream().sorted().toList();
        System.out.println(result);

        //Reverse order
        List<Integer> result1 = list.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> result2 = list.stream().sorted((a,b)-> b-a).toList();
        System.out.println(result1);

        //Top 3 highest numbers using sorted()
        List<Integer> result3 = list.stream().sorted((a,b)->b-a).limit(3).toList();
        System.out.println(result3);

        //Sort even numbers
        List<Integer> result4 = list.stream().filter(a->a%2==0).sorted().toList();
        System.out.println(result4);

        //Remove duplicates and sort the list using Stream sorted()
        List<Integer> result5 = list.stream().distinct().sorted().toList();
        System.out.println(result5);

        //Second highest number using sorted();
        List<Integer> result6 = list.stream().sorted((a,b)->b-a).limit(2).sorted().limit(1).toList();
        System.out.println(result6);

        //Sort the String list using sorted();
        List<String> list2 = Arrays.asList("Ravi", "Ankit", "Zoya", "Meena", "Kunal");
        List<String> result7 = list2.stream().sorted().toList();
        System.out.println(result7);

        //Sort the String list in reverse order using sorted()
        List<String> result8 = list2.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(result8);

        //Sort according to the length of the string using sorted()
        List<String> result9 = list2.stream().sorted((a,b)-> b.length()-a.length()).toList();
        System.out.println(result9);

    }
    
}
