package streamapi;
import java.util.*;
import java.util.stream.*;

public class StreamEx {
    public static void main(String[] args){
        List data = Arrays.asList(23,45,52,68,12,19,25);
       // List data = List.of(23,45,52,68,12,19,25);
       Stream info = Stream.of(23,45,65,85,952,3.5,"info");
       ArrayList<Integer> list = new ArrayList<>();
       list.addAll(data);
       System.out.println(list);
       Stream listStream = list.stream();
       list.stream().filter(n-> n>60).forEach(System.out::println);
       List<Integer> newList = list.stream().filter(n-> n>50&& n<70).toList();
       List<Integer> newList2 = list.stream().filter(n-> n>50&& n<70).collect(Collectors.toList());


    }
}
